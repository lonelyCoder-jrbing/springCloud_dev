package com.service.service.excel;

import lombok.Data;

/**
 * Created by yanglikai on 2019/4/11.
 */
@Data
public class ImportLog {

    private Integer line;

    private boolean success;

    private String message;

    public ImportLog(Integer line, boolean success, String message) {
        this.line = line;
        this.success = success;
        this.message = message;
    }

    public static ImportLog success(Integer line) {
        return new ImportLog(line, true, "ok");
    }

    public static ImportLog failed(Integer line, String message) {
        return new ImportLog(line, false, message);
    }
}
