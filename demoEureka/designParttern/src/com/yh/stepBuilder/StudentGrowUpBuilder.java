package com.yh.stepBuilder;
//此类不能被继承
public final class StudentGrowUpBuilder {

  private StudentGrowUpBuilder(){

  }

  public static StudentGrowUpSteps newBuilder(){
    return new StudentGrowUpSteps();
  }


}
