package ru.job4j.collection;

import java.util.*;

public class User implements Comparable<User> {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(User o) {
        return (this.name.compareTo(o.name) == 0) ? Integer.compare(this.age, o.age) : this.name.compareTo(o.name);
//        return Comparator.comparing(User::getName).thenComparing(User::getAge).compare(this, o);
    }

}
