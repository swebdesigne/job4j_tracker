package ru.job4j.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Diapason {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        BiFunction<Integer, Integer, List<Double>> dip = (x, y) -> {
            List<Double> rsl = new ArrayList<>();
            for (; x < y; x++) {
                rsl.add((func.apply((double) x)));
            }
           return rsl;
       };
        return dip.apply(start, end);
    }
}
