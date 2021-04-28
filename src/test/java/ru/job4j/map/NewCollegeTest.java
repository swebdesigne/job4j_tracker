package ru.job4j.map;

import org.junit.Test;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
public class NewCollegeTest {
    @Test
    public void whenAccountIsOptionalEmpty() {
        Map<NewStudent, Set<NewSubject>> students = Map.of(
                new NewStudent("Student1", "000001", "201-18-15"),
                Set.of(
                        new NewSubject("Math", 70),
                        new NewSubject("English", 85)
                ),
                new NewStudent("Student2", "000002", "201-18-15"),
                Set.of(
                        new NewSubject("Economic", 75),
                        new NewSubject("Sociology", 65)
                )
        );
        NewCollege college = new NewCollege(students);
        assertThat(college.findByAccount("000010"), is(Optional.empty()));
    }

    @Test
    public void whenAccountIsOptionalNotEmpty() {
        Map<NewStudent, Set<NewSubject>> students = Map.of(
                new NewStudent("Student1", "000001", "201-18-15"),
                Set.of(
                        new NewSubject("Math", 70),
                        new NewSubject("English", 85)
                ),
                new NewStudent("Student2", "000002", "201-18-15"),
                Set.of(
                        new NewSubject("Economic", 75),
                        new NewSubject("Sociology", 65)
                )
        );
        NewCollege college = new NewCollege(students);
        assertThat(college.findByAccount("000001").get().getGroup(), is("201-18-15"));
    }

    @Test
    public void whenSubjectIsOptionalEmptyWithNotFoundAccount() {
        Map<NewStudent, Set<NewSubject>> students = Map.of(
                new NewStudent("Student1", "000001", "201-18-15"),
                Set.of(
                        new NewSubject("Math", 70),
                        new NewSubject("English", 85)
                ),
                new NewStudent("Student2", "000002", "201-18-15"),
                Set.of(
                        new NewSubject("Economic", 75),
                        new NewSubject("Sociology", 65)
                )
        );
        NewCollege college = new NewCollege(students);
        assertThat(college.findBySubjectName("000010", "Sociology"), is(Optional.empty()));
    }

    @Test
    public void whenSubjectIsOptionalEmptyWithFoundAccount() {
        Map<NewStudent, Set<NewSubject>> students = Map.of(
                new NewStudent("Student1", "000001", "201-18-15"),
                Set.of(
                        new NewSubject("Math", 70),
                        new NewSubject("English", 85)
                ),
                new NewStudent("Student2", "000002", "201-18-15"),
                Set.of(
                        new NewSubject("Economic", 75),
                        new NewSubject("Sociology", 65)
                )
        );
        NewCollege college = new NewCollege(students);
        assertThat(college.findBySubjectName("000001", "Sociology"), is(Optional.empty()));
    }

    @Test
    public void whenSubjectIsOptionalNotEmpty() {
        Map<NewStudent, Set<NewSubject>> students = Map.of(
                new NewStudent("Student1", "000001", "201-18-15"),
                Set.of(
                        new NewSubject("Math", 70),
                        new NewSubject("English", 85)
                ),
                new NewStudent("Student2", "000002", "201-18-15"),
                Set.of(
                        new NewSubject("Economic", 75),
                        new NewSubject("Sociology", 65)
                )
        );
        NewCollege college = new NewCollege(students);
        assertThat(college.findBySubjectName("000002", "Sociology").get().getScore(), is(65));
    }
}