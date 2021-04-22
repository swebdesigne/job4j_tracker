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
                new Student(25, "Ivanov"),
                new Student(12, "Petrov"),
                new Student(33, "Sidorov")
        );
        Map<String, Student> rsl = new HashMap<>();
        rsl.put("Ivanov", new Student(25, "Ivanov"));
        rsl.put("Petrov", new Student(12, "Petrov"));
        rsl.put("Sidorov", new Student(33, "Sidorov"));
        assertThat(ConvertStudent.convert(students), is(rsl));
    }

}