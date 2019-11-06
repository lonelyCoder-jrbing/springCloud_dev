package com.service.service.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class MemberTagEntity extends BaseRowModel {
    private String memberId;
    private String tagType;
    private String tagValue;

}
