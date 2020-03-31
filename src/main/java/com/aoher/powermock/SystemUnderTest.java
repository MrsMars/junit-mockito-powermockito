package com.aoher.powermock;

import java.util.ArrayList;
import java.util.List;

public class SystemUnderTest {

    private Dependency dependency;

    public int methodUsingAnArrayListConstructor() {
        ArrayList list = new ArrayList();
        return list.size();
    }

    public int methodCallingAStaticMethod() {
        List<Integer> stats = dependency.retrieveAllStats();
        long sum = stats.stream().mapToInt(stat -> stat).asLongStream().sum();
        return UtilityClass.staticMethod(sum);
    }

    private long privateMethodUnderTest() {
        List<Integer> stats = dependency.retrieveAllStats();
        return stats.stream().mapToInt(stat -> stat).asLongStream().sum();
    }
}
