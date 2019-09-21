package com.example.jdk8.functionTest;

public class Test02 implements MyInterface {


  @Override
  public String getName() {
    String dosomething = dosomething(name);
    return dosomething;
  }

  public static void main(String[] args) {
    Test02 t = new Test02();
    String name = t.getName();
    System.out.println("name:   " + name);
  }
}
