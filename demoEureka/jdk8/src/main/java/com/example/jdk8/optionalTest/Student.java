package com.example.jdk8.optionalTest;

import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;
import lombok.Data;

import java.util.Optional;

@Data
public class Student {

  private Optional<String> name;
  private Optional<Integer> age;


}
