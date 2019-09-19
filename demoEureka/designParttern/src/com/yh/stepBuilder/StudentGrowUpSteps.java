package com.yh.stepBuilder;

import java.util.Optional;

public class StudentGrowUpSteps implements BuilderStep ,ChineseStep,MathStep,PhsicalStep{
  private String name;
  private String chineseClass;
  private String mathClass;
  private String phsicalClass;
  private String PhlosophiaClass;



  @Override
  public Student build(String name) {
    Student s = new Student(name);
    Optional<String> chineseClass = Optional.ofNullable(this.chineseClass);
    s.setChineseClass(chineseClass.get());
    Optional<String> mathClass = Optional.ofNullable(this.mathClass);
    s.setMathClass(mathClass.get());
    Optional<String> phsicalClass = Optional.ofNullable(this.phsicalClass);
    s.setPhsicalClass(phsicalClass.get());
    return s;
  }

  @Override
  public PhsicalStep learningChinese(String chineseClass) {
    this.chineseClass = chineseClass;
    return this;
  }

  @Override
  public ChineseStep learningMath(String mathClass) {
    this.mathClass = mathClass;
    return this;
  }


  @Override
  public BuilderStep graduateAfterPhsicalStep(String phsicalClass) {
    this.phsicalClass = phsicalClass;
    return this;
  }
}
