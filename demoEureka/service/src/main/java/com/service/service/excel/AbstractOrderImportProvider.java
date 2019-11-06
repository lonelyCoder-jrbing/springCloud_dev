package com.service.service.excel;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by yanglikai on 2019/4/11.
 */
public abstract class AbstractOrderImportProvider<I, O> extends ImportResultUpload implements OrderImportProvider<I, O> {

  protected List<I> datas;

  private List<ImportLog> importLogs;

  protected OrderImportContext context;

  public AbstractOrderImportProvider() {
    this.importLogs = new ArrayList<>();
  }

  protected void appendLog4Success(Integer line) {
    importLogs.add(ImportLog.success(line));
  }

  protected void appendLog4Failed(Integer line, String message) {
    importLogs.add(ImportLog.failed(line, message));
  }

/*  *//**
   * 获取主数据提供者
   *
   * @return
   *//*
  protected IMasterDataProvider getMasterDataProvider() {
    MasterDataProviderManager providerManager = SpringContextManager.getBean(MasterDataProviderManager.class);
    if (providerManager == null) return null;
    return providerManager.getProvider();
  }*/

  @Override
  public OrderImportProvider<I, O> fetch(OrderImportContext context) {
    this.context = context;
    this.datas =new ExcelUtil().readExcel(context.getRequest(), importTarget());
    return this;
  }

  @Override
  public OrderImportResult<O> tResult() {
    if (hasError()) {
      return processToFail();
    }

    return processToSucc();
  }


  private OrderImportResult processToSucc() {
    OrderImportResult<O> result = new OrderImportResult<>();
    result.setData(fillData());

    return result;
  }

  private OrderImportResult processToFail() {
    /* 错误信息上传至FTP */
    String downloadUrl = upload(context, importLogs);

    long successCount = importLogs.stream().filter(el -> el.isSuccess()).count();
    long failedCount = importLogs.stream().filter(el -> el.isSuccess() == false).count();

    /* 构建返回结果 */
    OrderImportResult<O> result = new OrderImportResult<>();
    result.setSuccess(false);
    result.setMessage(
        String.format("导入失败(共%s条数据,正确%s条,错误%s条)", importLogs.size(), successCount, failedCount));
    result.setDownloadUrl(downloadUrl);

    return result;
  }

  private boolean hasError() {
    long count =
        importLogs.stream().filter(el -> el.isSuccess() == false).count();

    return count > 0;
  }


  protected abstract Class importTarget();

  protected abstract List<O> fillData();

  protected static <T> Predicate<T> distinctByKeys(Function<? super T, ?>... keyExtractors) {
    final Map<List<?>, Boolean> seen = new ConcurrentHashMap<>();
    return t -> {
      final List<?> keys = Arrays.stream(keyExtractors)
              .map(ke -> ke.apply(t))
              .collect(Collectors.toList());
      return seen.putIfAbsent(keys, Boolean.TRUE) == null;
    };
  }
}
