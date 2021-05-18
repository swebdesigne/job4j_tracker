package ru.job4j.stream;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public interface EasyStreamBuilder {
    EasyStream of(List<Integer> source);

    EasyStream map(Function<Integer, Integer> fun);

    EasyStream filter(Predicate<Integer> fun);

    List<Integer> collect();
}
