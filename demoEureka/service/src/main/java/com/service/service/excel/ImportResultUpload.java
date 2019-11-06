package com.service.service.excel;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by yanglikai on 2019/4/23.
 */
public abstract class ImportResultUpload {

  private static final String PATH_NAME = "/home/www/import/result";

  public String upload(OrderImportContext context, List<ImportLog> importLogs) {
//    FTPProperties ftp = context.getFtpProperties();

  /*  List<MultipartFile> multipartFiles = ExcelUtil.getMultipartFile(context.getRequest());

    String fileName = "FACTORY_IMPORT_ERROR_" + DateUtil.formatTime(new Date(), "yyyyMMddHHmmss") + ".xlsx";
    try {
      InputStream oldInputStream = multipartFiles.get(0).getInputStream();
      InputStream newInputStream = setupErrorMsg(oldInputStream, importLogs);

      FTPClientManager
          .init(ftp.getHost())
          .userName(ftp.getUserName()).password(ftp.getPassword())
          .upload(PATH_NAME, fileName, newInputStream);
    } catch (IOException e) {
      ExceptionLogCollector.collect(e);

      throw new BizException(ErrorCodeEnum.GL99990003);
    }


    StringBuffer downloadUrl = new StringBuffer();
    downloadUrl.append("ftp://");
    downloadUrl.append(ftp.getHost());
    downloadUrl.append("/import/result/");
    downloadUrl.append(fileName);
    return downloadUrl.toString();*/
  return null;
  }

  private static InputStream setupErrorMsg(InputStream inputStream, List<ImportLog> importLogs) {
    try (Workbook workbook = WorkbookFactory.create(inputStream)) {
      Sheet sheet = workbook.getSheetAt(0);

      /* 字体 */
      Font cellFont = workbook.createFont();
      cellFont.setColor(Font.COLOR_RED);

      /* 单元格格式 */
      CellStyle cellStyle = workbook.createCellStyle();
      cellStyle.setFont(cellFont);

      /* 标题行 */
      final String errorTitle = "错误提示";
      Row titleRow = sheet.getRow(1);
      Cell titleCell = titleRow.createCell(titleRow.getLastCellNum());
      titleCell.setCellStyle(cellStyle);
      titleCell.setCellValue(errorTitle);

      /* 数据行 */
      for (ImportLog importLog : importLogs) {
        if (importLog.isSuccess()) {
          continue;
        }

        Row dataRow = sheet.getRow(importLog.getLine());
        if (dataRow == null) {
          continue;
        }

        Cell dataCell = dataRow.createCell(dataRow.getLastCellNum());
        dataCell.setCellStyle(cellStyle);
        dataCell.setCellValue(importLog.getMessage());
      }

      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      workbook.write(outputStream);
      return new ByteArrayInputStream(outputStream.toByteArray());
    } catch (InvalidFormatException e) {
//      ExceptionLogCollector.collect(e);
    } catch (IOException e) {
//      ExceptionLogCollector.collect(e);
    }

    return inputStream;
  }
}
