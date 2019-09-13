package com.example.jdk8.functionTest;

import java.util.function.Function;

public class Test01 {

  public static void main(String[] args) {

    Function<Integer, Integer> name = e -> e * 2;
    Function<Integer, Integer> square = e -> e * e;
    //apply
    Integer num1 = name.apply(2);
    System.out.println(num1);
    //andThen
    Integer num2 = name.andThen(square).apply(4);
    System.out.println(num2);
    //compose
    Integer num3 = name.compose(square).apply(3);
    System.out.println(num3);


  }

}
