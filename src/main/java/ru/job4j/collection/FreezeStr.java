package ru.job4j.collection;

import java.util.Arrays;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        char[] a = left.toCharArray();
        char[] b = right.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }
}
