package com.service.service.excel;

import lombok.Data;

import java.util.List;

/**
 * Created by yanglikai on 2019/4/12.
 */
@Data
public class OrderImportResult<T> {
    private boolean success;

    private String message;

    private List<T> data;

    private String downloadUrl;

    public OrderImportResult() {
        this.success = true;
        this.message = "ok";
    }
}
