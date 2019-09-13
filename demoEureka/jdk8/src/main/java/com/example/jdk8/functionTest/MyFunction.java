package com.example.jdk8.functionTest;

import java.util.function.Function;

public class MyFunction implements Function<String,Integer> {

  @Override
  public Integer apply(String s) {
    return s.codePointAt(3);
  }


}
