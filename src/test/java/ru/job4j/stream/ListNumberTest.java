package ru.job4j.stream;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;

public class ListNumberTest {
    @Test
    public void convertMatrixToListNumbers() {
        int[][] arrays = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> rsl = Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 8, 9
        );
        assertThat(ListNumber.convertMatrixToListNumbers(arrays), is(rsl));
    }
}