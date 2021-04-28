package ru.job4j.stream;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.hamcrest.core.Is.is;

import static org.junit.Assert.*;

public class StudentTest {
    @Test
    public void listConvertToMap() {
        List<Student> students = List.of(
                new Student("Ivanov", 25),
                new Student("Petrov", 12),
                new Student("Sidorov", 33)
        );
        Map<String, Student> rsl = new HashMap<>();
        rsl.put("Ivanov", new Student("Ivanov", 25));
        rsl.put("Petrov", new Student("Petrov", 12));
        rsl.put("Sidorov", new Student("Sidorov", 33));
        assertThat(ConvertStudent.convert(students), is(rsl));
    }

    @Test
    public void whenIsDublicat() {
        List<Student> students = List.of(
                new Student("Ivanov", 25),
                new Student("Petrov", 12),
                new Student("Petrov", 12),
                new Student("Sidorov", 33)
        );
        Map<String, Student> rsl = new HashMap<>();
        rsl.put("Ivanov", new Student("Ivanov", 25));
        rsl.put("Petrov", new Student("Petrov", 12));
        rsl.put("Sidorov", new Student("Sidorov", 33));
        assertThat(ConvertStudent.convert(students), is(rsl));
    }
}