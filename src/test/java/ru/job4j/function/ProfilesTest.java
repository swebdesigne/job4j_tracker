package ru.job4j.function;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void collect() {
        List<Profile> pr = List.of(
            new Profile(new Address("Дубна", "Энтузиастов", 12, 1)),
            new Profile(new Address("Луховицы", "Боголюбова", 1, 33)),
            new Profile(new Address("Кимры", "Павлова", 29, 21))
        );
        List<Address> rsl = new Profiles().collect(pr);
        List<Address> expected = Arrays.asList(
               new Address("Дубна", "Энтузиастов", 12, 1),
               new Address("Луховицы", "Боголюбова", 1, 33),
               new Address("Кимры", "Павлова", 29, 21)
        );
        assertThat(rsl, is(expected));
    }
}