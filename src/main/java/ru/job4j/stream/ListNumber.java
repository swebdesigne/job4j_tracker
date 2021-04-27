package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListNumber {
    public static List<Integer> convertMatrixToListNumbers(Integer[][] arrays) {
        return Arrays.stream(arrays)
                .flatMap(i -> Stream.of(i))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<List<Integer>> matrix = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );
        System.out.println(matrix.stream().flatMap(e -> e.stream()).collect(Collectors.toList()));
    }
}
