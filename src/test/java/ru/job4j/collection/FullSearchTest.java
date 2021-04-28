package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class FullSearchTest {

    @Test
    public void extractNumber() {
        List<Task> task = List.of(
                new Task("1", "First desc"),
                new Task("2", "Second desc"),
                new Task("1", "First desc")
        );
        Set<String> expected = new HashSet<>(List.of("1", "2"));
        assertThat(FullSearch.extractNumber(task), is(expected));
    }
}