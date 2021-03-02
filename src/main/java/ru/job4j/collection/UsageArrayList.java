package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Petr");
        names.add("Ivan");
        names.add("Stepan");
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            System.out.println(name);
        }
        for (String name: names) {
            System.out.println(name);
        }
    }
}
