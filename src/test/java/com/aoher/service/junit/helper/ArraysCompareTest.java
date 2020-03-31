package com.aoher.service.junit.helper;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;

public class ArraysCompareTest {

    @Test
    public void testArraySortRandomArray() {
        int[] numbers = { 12, 3, 4, 1 };
        int[] expected = { 1, 3, 4, 12 };

        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers);
    }

    @Test(expected = NullPointerException.class)
    public void testArraySortNullArray() {
        int[] numbers = null;
        Arrays.sort(numbers);
    }

    @Test(timeout = 100)
    public void testSortPerformance() {
        int[] array = { 12, 23, 4 };

        IntStream.range(1, 1000000).forEach(i -> {
            array[0] = i;
            Arrays.sort(array);
        });
    }
}
