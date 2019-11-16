package com.example.jdk8.streamTest.lambdaTest.groupTest;

import com.example.jdk8.streamTest.Teacher;
import com.example.jdk8.streamTest.lambdaTest.Utils.CollectionProviders;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Demo01 {

    @Test
    public void test01(){
        List<Teacher> teacherList = CollectionProviders.getProvider().getTeacherList();

//        teacherList.stream().collect(Collectors.groupingBy(e->{e.getName().get(),Collectors.mapping(e.getAge().get(),Collectors.toList())};);
    }







}
