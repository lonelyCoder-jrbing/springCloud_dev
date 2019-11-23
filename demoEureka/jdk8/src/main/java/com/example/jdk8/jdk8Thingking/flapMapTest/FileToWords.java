package com.example.jdk8.jdk8Thingking.flapMapTest;

import java.io.IOException;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.nio.file.*;

public class FileToWords {
    public static Stream<String> stream(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath)).skip(1)
                .flatMap(lines -> Pattern.compile("\\W+").splitAsStream(lines));
    }

}
