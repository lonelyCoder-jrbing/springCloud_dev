package com.example.jdk8.optionalTest;

import com.sun.corba.se.impl.orb.ParserTable;

import javax.xml.crypto.Data;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test01 {
    public static void main(String[] args) {
        Student s = new Student();
        s.setAge(Optional.of(12));
        s.setName(Optional.of("jrbing"));
        Student s2 = null;
        Optional<Student> s21 = Optional.ofNullable(s2);
        //Optional<Student> s1 = Optional.of(s);
        Optional<Student> s1 = Optional.ofNullable(s);
        System.out.println("s1:    " + s1.get());
        System.out.println(s1.isPresent());
        System.out.println(s21.orElse(s));

        System.out.println(s21.orElseGet(()->new Student()));
        System.out.println("=====================");
//        System.out.println(s21.orElseThrow(()->new RuntimeException()));
        testPredict();
    }

    private static void testPredict() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        List<Integer> list = new ArrayList<>();
        for (int i : numbers) {
            list.add(i);
        }

        // 三个判断
        Predicate<Integer> p1 = i -> i > 5;
        Predicate<Integer> p2 = i -> i < 20;
        Predicate<Integer> p3 = i -> i % 2 == 0;
        List test = list.stream()
                .filter(p1
                        .and(p2)
//                        .and(Predicate.isEqual(8))
                        .and(p3))
                .collect(Collectors.toList());
        System.out.println(test.toString());
        //print:[6, 8, 10, 12, 14]
    }
}
