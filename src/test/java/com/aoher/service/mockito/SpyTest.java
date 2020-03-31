package com.aoher.service.mockito;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest {

    private static final String INPUT_1 = "Ranga";
    private static final String INPUT_2 = "in28Minutes";

    @Test
    public void creatingASpyOnArrayList() {
        List<String> listSpy = spy(ArrayList.class);
        listSpy.add(INPUT_1);
        listSpy.add(INPUT_2);

        verify(listSpy).add(INPUT_1);
        verify(listSpy).add(INPUT_2);

        assertEquals(2, listSpy.size());
        assertEquals(INPUT_1, listSpy.get(0));
    }

    @Test
    public void creatingASpyOnArrayListOverridingSpecificMethods() {
        List<String> listSpy = spy(ArrayList.class);
        listSpy.add(INPUT_1);
        listSpy.add(INPUT_2);

        stub(listSpy.size()).toReturn(-1);

        assertEquals(-1, listSpy.size());
        assertEquals(INPUT_1, listSpy.get(0));
    }
}
