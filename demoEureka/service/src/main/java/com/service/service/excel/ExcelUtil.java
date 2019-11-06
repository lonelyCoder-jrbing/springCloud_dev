package com.service.service.excel;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
@Slf4j
public class ExcelUtil<I> extends AnalysisEventListener {

    private List<Object> datas = new ArrayList<>();

    @Override
    public void invoke(Object o, AnalysisContext analysisContext) {
        datas.add(o);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        datas.clear();

    }

    public   List<I> readExcel(HttpServletRequest request,Class clazz)  {
        BufferedInputStream buffer = null;
        List<I> list =null;
        try {
            buffer = new BufferedInputStream(request.getInputStream());
            ExcelUtil listener = new ExcelUtil();
            ExcelReader excelReader = new ExcelReader(buffer, ExcelTypeEnum.XLS, listener);
            excelReader.read(new Sheet(1, 0, clazz));
             list = listener.getDatas();

            //excel中第一行为栏目，必然是存在一行的
            if (CollectionUtils.isEmpty(list) || list.size() < 2) {
                throw new Exception("导入数据为空！");
            }
        } catch (Exception e) {
            log.info("批量导入会员打标失败", e);
        } finally {
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (IOException e) {
                    log.error("导入失败", e);
                }
            }
        }
        return list;
    }
}
