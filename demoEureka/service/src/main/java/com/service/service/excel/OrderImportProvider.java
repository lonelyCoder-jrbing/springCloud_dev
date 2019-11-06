package com.service.service.excel;

/**
 * Created by yanglikai on 2019/4/11.
 */
public interface OrderImportProvider<I,O> {

  OrderImportProvider<I,O> fetch(OrderImportContext context);

  OrderImportProvider<I,O> check();

  OrderImportResult<O> tResult();
}
