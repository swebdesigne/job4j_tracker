package ru.job4j.function;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + right.length() + " : " + left.length());
            return Integer.compare(right.length(), left.length());
        };
        List<String> str = Arrays.asList("Igor", "Boris");
        Collections.sort(str, cmpDescSize);
        System.out.println(str);
    }
}
