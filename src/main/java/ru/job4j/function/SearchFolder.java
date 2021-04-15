package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class SearchFolder {
    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        List<Folder> rsl = new ArrayList<>();
        for (Folder l : list) {
            if (pred.test(l)) {
                rsl.add(l);
            }
        }
        return rsl;
    }
 }
