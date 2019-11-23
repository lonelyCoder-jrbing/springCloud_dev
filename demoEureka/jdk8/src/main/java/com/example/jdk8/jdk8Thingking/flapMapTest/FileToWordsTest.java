package com.example.jdk8.jdk8Thingking.flapMapTest;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
public class FileToWordsTest {
    //
    public static void main(String[] args) throws IOException {

//        File directory = new File("abc.txt");
//        String canonicalPath = directory.getCanonicalPath();
//        System.out.println(canonicalPath);

        long timeBegin = System.currentTimeMillis();
        log.info("开始读取文件,并且开始使用mapreduce进行 计数,开始时间为:  {}", timeBegin);
        FileToWords.stream("D:\\code\\springCloud\\words")
                .collect(Collectors.groupingBy(e -> e.toLowerCase())).values().stream().map(x -> {
            Map<String, Integer> map = new HashMap<>();
            map.put(x.get(0), x.size());
            return map;

        }).peek(e -> {
            System.out.println("test peek:   " + e);
        }).forEach(e -> {

            Set<Map.Entry<String, Integer>> entries = e.entrySet();
            Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        });
        long timeEnd = System.currentTimeMillis();
        long timeUsed = timeEnd - timeBegin;
        log.info("单词计算结束,结束时间为===========>{},使用时间为====>{}", timeEnd, timeUsed);

    }
}
