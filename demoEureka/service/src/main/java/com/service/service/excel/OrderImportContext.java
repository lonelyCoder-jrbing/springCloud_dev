package com.service.service.excel;


import javax.servlet.http.HttpServletRequest;


/**
 * Created by yanglikai on 2019/4/11.
 */
public class OrderImportContext {

    private HttpServletRequest request;

    public HttpServletRequest getRequest() {
        return request;
    }

    public OrderImportContext(HttpServletRequest request) {
        this.request = request;
    }

}
