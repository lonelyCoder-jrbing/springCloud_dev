package com.example.jdk8.streamTest;

import java.util.Optional;
import lombok.Data;

@Data
public class Teacher {
private Optional<String> name;
private Optional<Integer> age;
}
