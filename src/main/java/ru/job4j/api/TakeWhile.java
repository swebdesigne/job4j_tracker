package ru.job4j.api;
import javax.swing.*;
import java.util.List;
import java.util.stream.Stream;

public class TakeWhile {
    public static void main(String[] args) {
        List.of(1, 2, 3, 4).stream()
                .takeWhile(v -> v < 3)
                .map(v -> "Result: " + v)
                .forEach(System.out::println);
        System.out.println("==================");
        List.of(1, 2, 3, 4).stream()
                .dropWhile(v -> v < 3)
                .map(v -> "Result: " + v)
                .forEach(System.out::println);
        System.out.println("==================");
        Stream.of(1, null, 2, null, 3)
                .flatMap(Stream::ofNullable)
                .map(v -> "Result: "  + v)
                .forEach(System.out::println);
    }
}
