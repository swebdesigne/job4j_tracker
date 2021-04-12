package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class FreezeStr {
    public static HashMap<Character, Integer> put(char[] arr) {
        HashMap<Character, Integer> check = new HashMap<>();
        for (char word : arr) {
            if (check.containsKey(word)) {
                check.put(word, check.get(word) + 1);
            } else {
                check.put(word, 1);
            }
        }
        return check;
    }

    public static boolean eq(String left, String right) {
        char[] l = left.toCharArray();
        char[] r = right.toCharArray();
        HashMap<Character, Integer> check = put(l);
        for (char i : r) {
            if (!check.containsKey(i)) {
                return false;
            } else {
                if (check.get(i) == 1) {
                    check.remove(i);
                } else {
                    check.put(i, check.get(i) - 1);
                }
            }
        }
        return check.isEmpty();
    }
}
