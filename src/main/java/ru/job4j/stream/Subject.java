package ru.job4j.stream;

public class Subject {
    private String name;
    private int scope;

    public Subject(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public int getScope() {
        return scope;
    }
}
