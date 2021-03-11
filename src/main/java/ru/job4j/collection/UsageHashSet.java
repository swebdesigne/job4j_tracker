package ru.job4j.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> autos  = new HashSet<String>();
        autos .add("Lada");
        autos .add("BMW");
        autos .add("Volvo");
        autos .add("Toyota");
        for (String auto : autos) {
            System.out.println(auto);
        }
    }
}
