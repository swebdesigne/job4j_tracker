package ru.job4j.collection;

import java.util.HashMap;
import java.util.HashSet;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        String[] left = origin.replaceAll("\\p{P}", "").split(" ");
        String[] right = line.replaceAll("\\p{P}", "").split(" ");
        HashMap<String, Integer> check = new HashMap<>();
        for (String word : left) {
            if (check.containsKey(word)) {
                check.put(word, check.get(word) + 1);
            } else {
                check.put(word, 1);
            }
        }
        for (String word : right) {
            // if (check.get(word) == 0)
            if (!check.containsKey(word)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
