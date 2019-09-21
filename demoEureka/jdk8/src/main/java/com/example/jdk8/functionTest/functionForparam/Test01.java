package com.example.jdk8.functionTest.functionForparam;

import com.example.jdk8.functionTest.MyFunction;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Test01 {

  public static void main(String[] args) {
    //
//    Function function = new MyFunction();
    Function<Integer,String> str  = e-> String.valueOf(e);
    Iterable list = getList(str);
    if (list instanceof ArrayList) {
      System.out.println("是一个ArrayList。。。");
      list.forEach(Test01::printnum);
    }

  }

  private static void printnum(Object o) {
    System.out.println(o);
  }

  public static <T> Iterable<String> getList(Function<Integer, String> function) {
    List<Integer> list = new ArrayList<>();
    List<String> newList = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.forEach(e -> {
      String apply = function.apply(e);
      newList.add(apply);
    });
    return newList;
  }


}
