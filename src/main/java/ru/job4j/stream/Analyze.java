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
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(value -> new Tuple(
                        value.getName(),
                        value.getSubjects()
                                .stream().mapToInt(Subject::getScore).average().orElse(0D))
                ).collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName, LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScore))
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
                                .stream().mapToInt(Subject::getScore).sum())
                ).max((entry1, entry2) ->
                        (int) (entry1.getScore() - entry2.getScore())).orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName, LinkedHashMap::new,
                        Collectors.summingDouble(Subject::getScore))
                ).entrySet()
                .stream()
                .map(convert -> new Tuple(convert.getKey(), convert.getValue()))
                .max((entry1, entry2) ->
                        (int) (entry1.getScore() - entry2.getScore())).orElse(null);
    }
}
