package ru.job4j.stream;

import java.util.Objects;

public class Tuple {
    private String name;
    private double scope;

    public Tuple(String name, double scope) {
        this.name = name;
        this.scope = scope;
    }

    public double getScope() {
        return scope;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple tuple = (Tuple) o;
        return Double.compare(tuple.scope, scope) == 0 &&
                Objects.equals(name, tuple.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, scope);
    }
}
