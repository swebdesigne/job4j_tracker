package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        for (int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
            char a = o1.charAt(i);
            char b = o2.charAt(i);
            if (a != b) {
                return Character.compare(a, b);
            }
        }
        return Integer.compare(o1.length(), o2.length());
    }
}
