package ru.job4j.function;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void collect() {
        Profile profile = new Profile(new Address("Дубна", "Энтузиастов", 12, 1));
        Profile profile1 = new Profile(new Address("Луховицы", "Боголюбова", 1, 33));
        Profile profile2 = new Profile(new Address("Кимры", "Павлова", 29, 21));
        List<Profile> pr = new ArrayList<>();
        pr.add(profile);
        pr.add(profile1);
        pr.add(profile2);
        Profiles profiles = new Profiles();
        profiles.collect(pr);
//        Predicate<Student> pr = student -> student.getScore() >= 70;
//        List<Student> rsl = sc.collect(students, pr);
//        List<Student> expected = new ArrayList<>();
//        expected.add(new Student(70, "Surname7"));
//        expected.add(new Student(90, "Surname9"));
//        assertThat(rsl, is(expected));
    }
}