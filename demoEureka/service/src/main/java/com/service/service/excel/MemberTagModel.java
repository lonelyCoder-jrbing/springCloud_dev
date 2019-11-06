package com.service.service.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberTagModel extends BaseRowModel {

    @ExcelProperty(value="会员ID",index=0)
    private String memberId;

    @ExcelProperty(value="标签类型",index=1)
    private String tagType;

    @ExcelProperty(value="标签值",index=2)
    private String tagValue;

}
