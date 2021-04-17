package ru.job4j.function;

import java.util.function.Function;
import java.util.function.BiFunction;

public class FurtherPractice implements MyValue {

    public static String rInt(String str, int num) {
        BiFunction<Integer, String, String> i = (x, y) -> {
            return String.valueOf(str + (x + 2));
        };
        return i.apply(num, str);
    }

    public static void main(String[] args) {
        System.out.println(rInt("This is equation equals ", 2));
        MyValue myValue;
        myValue = (num) -> num + 98.6;
        System.out.println(myValue.getValue(2));
        System.out.println(new FurtherPractice().getValue(98.6));
    }

    @Override
    public double getValue(double num) {
        return num;
    }
}
