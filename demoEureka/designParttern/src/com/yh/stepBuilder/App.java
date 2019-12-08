package com.yh.stepBuilder;

public class App {

    public static void main(String[] args) {
        Student s = StudentGrowUpBuilder.newBuilder().learningMath("learn so Aigorithms")
                .learningChinese("learning how to read pom")
                .graduateAfterPhsicalStep("learn how to compute earth gravity ").build("zhangssan");
        System.out.println("s:     " + s);
    }

}
