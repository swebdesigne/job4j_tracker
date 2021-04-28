package ru.job4j.stream;

import java.util.Optional;
import java.util.stream.Stream;

public class OptStream {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3);
        Optional<Integer> rsl = stream.filter(e -> e == 3).findFirst();
        if (rsl.isPresent()) {
            System.out.println(rsl.get());
        } else {
            System.out.printf("Element not found");
        }
    }
}
