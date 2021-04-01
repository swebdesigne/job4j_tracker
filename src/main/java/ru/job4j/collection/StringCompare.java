package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl = 0;
        for (int i = 0; i < Math.max(o1.length(), o2.length()); i++) {
            int a = (i < o1.length()) ? o1.charAt(i) : 0;
            int b = (i < o2.length()) ? o2.charAt(i) : 0;
            if (a != b) {
                rsl = Integer.compare(a, b);
                break;
            }
        }
        return rsl;
    }
}
