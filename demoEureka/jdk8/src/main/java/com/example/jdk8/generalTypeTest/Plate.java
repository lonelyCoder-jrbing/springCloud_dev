package com.example.jdk8.generalTypeTest;

public class Plate<T> {

  private T t;

  public void setT(T t) {
    this.t = t;
  }

  public T getT() {
    return t;
  }
}
