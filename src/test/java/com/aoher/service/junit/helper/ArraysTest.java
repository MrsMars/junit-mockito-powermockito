package com.aoher.service.junit.helper;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArraysTest {

    @Test(timeout = 100)
    public void testPerformance() {
        IntStream.range(0, 1000000).mapToObj(i -> new int[]{i, i - 1, i + 1}).forEach(Arrays::sort);
    }
}
