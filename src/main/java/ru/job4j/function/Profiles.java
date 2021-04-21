package ru.job4j.function;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(value -> value.getAddress())
                .sorted(Comparator.comparing(value -> value.getCity()))
                .distinct()
                .collect(Collectors.toList());
    }
}
