package com.yh.businessDelegate;

import java.util.Optional;

public enum ServiceType {
  JMS(Optional.ofNullable("kafka"), Optional.ofNullable(12)), EJB(
      Optional.ofNullable("what's this"), Optional.ofNullable(13));
  private Optional<String> name;
  private Optional<Integer> num;

  ServiceType(Optional<String> name, Optional<Integer> num) {
    this.name = name;
    this.num = num;
  }

  public Optional<String> getName() {
    return name;
  }

  public Optional<Integer> getNum() {
    return num;
  }
}
