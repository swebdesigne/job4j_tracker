package ru.job4j.function;

public class MyIntNum {
    private int v;

    public  MyIntNum(int x) {
        this.v = x;
    }

    public int getNum() {
        return v;
    }

    boolean isFactor(int n) {
        return (v % n) == 0;
    }
}
