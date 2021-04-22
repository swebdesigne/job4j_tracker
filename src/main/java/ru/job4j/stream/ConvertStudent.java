package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ConvertStudent {
    public static Map<String, Student> convert(List<Student> students) {
        return students.stream()
                .collect(
                        Collectors.toMap(
                                student -> String.valueOf(student.getSurname()),
                                student -> student
                        )
                );
    }
}
