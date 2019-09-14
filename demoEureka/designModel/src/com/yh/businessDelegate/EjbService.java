package com.yh.businessDelegate;

public class EjbService implements BusinessService {

  @Override
  public void doProcessing() {
    System.out.println("do ejb service....");
  }
}
