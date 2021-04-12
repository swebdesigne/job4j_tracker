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
        boolean rsl = true;
        char[] l = left.toCharArray();
        char[] r = right.toCharArray();
        HashMap<Character, Integer> check = put(l);
        HashMap<Character, Integer> check2 = put(r);
        for (char i : check.keySet()) {
            if (!check2.containsKey(i) || !check2.get(i).equals(check.get(i))) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
