package ru.job4j.stream;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(subject -> subject.getSubjects().stream())
                .mapToInt(Subject::getScope)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(value -> new Tuple(
                        value.getName(),
                        value.getSubjects()
                                .stream().mapToInt(Subject::getScope).average().orElse(0D))
                ).collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName, LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScope))
                ).entrySet()
                .stream()
                .map(convert -> new Tuple(convert.getKey(), convert.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(value -> new Tuple(
                        value.getName(),
                        value.getSubjects()
                                .stream().mapToInt(Subject::getScope).sum())
                ).max(Comparator.comparingDouble(Tuple::getScope)).orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        Collectors.summingDouble(Subject::getScope))
                ).entrySet()
                .stream()
                .map(convert -> new Tuple(convert.getKey(), convert.getValue()))
                .max(Comparator.comparing(Tuple::getScope)).orElse(null);
    }
}
