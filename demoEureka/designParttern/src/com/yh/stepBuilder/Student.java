package com.yh.stepBuilder;

public class Student {

    private String name;
    private String chineseClass;
    private String mathClass;
    private String phsicalClass;
    private String PhlosophiaClass;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String getChineseClass() {
        return chineseClass;
    }

    public String getMathClass() {
        return mathClass;
    }

    public String getPhsicalClass() {
        return phsicalClass;
    }

    public String getPhlosophiaClass() {
        return PhlosophiaClass;
    }

    public void setChineseClass(String chineseClass) {
        this.chineseClass = chineseClass;
    }

    public void setMathClass(String mathClass) {
        this.mathClass = mathClass;
    }

    public void setPhsicalClass(String phsicalClass) {
        this.phsicalClass = phsicalClass;
    }

    public void setPhlosophiaClass(String phlosophiaClass) {
        PhlosophiaClass = phlosophiaClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", chineseClass='" + chineseClass + '\'' +
                ", mathClass='" + mathClass + '\'' +
                ", phsicalClass='" + phsicalClass + '\'' +
                ", PhlosophiaClass='" + PhlosophiaClass + '\'' +
                '}';
    }
}
