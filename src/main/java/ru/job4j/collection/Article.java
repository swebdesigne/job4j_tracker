package ru.job4j.collection;

import java.util.HashSet;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        String[] originTest = origin.replaceAll("[,.;!-]", "").split(" ");
        String[] text = line.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String str : originTest) {
            check.add(str.trim());
        }
        for (String txt : text) {
            if (!check.contains(txt)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
