package ru.job4j.function;

import ru.job4j.lambda.Attachment;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23),
        };
        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return o1.getSize() - o2.getSize();
            }
        };
        Comparator<Attachment> comparator1 = (left, right) -> right.getSize() - left.getSize();
        Arrays.sort(atts, comparator1);
        for (Attachment a : atts) {
            System.out.println(a.getName() + " = " +  a.getSize());
        }
        Comparator<String> cmpText = (left, right) -> right.compareTo(left);
        Comparator<String> cmpDescSize = (left, right) -> Integer.compare(right.length(), left.length());
        List<String> str = Arrays.asList("Igor", "Boris");
        Collections.sort(str, cmpDescSize);
        System.out.println(str);
    }
}
