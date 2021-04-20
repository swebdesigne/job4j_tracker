package ru.job4j.function;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        for (Profile pr :profiles) {
            System.out.println(pr.getAddress().getCity());
        }
        return profiles.stream().map(value -> value.getAddress())
                .collect(Collectors.toList());
    }
}
