package ru.job4j.function;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(value -> value.getAddress())
                .collect(Collectors.toList());
    }
}
