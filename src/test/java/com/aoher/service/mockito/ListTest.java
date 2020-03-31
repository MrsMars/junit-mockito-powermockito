package com.aoher.service.mockito;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    private static final String INPUT = "in28Minutes";
    private List<String> list;

    @Before
    public void setUp() {
        list = (List<String>) mock(List.class);
    }

    @Test
    public void letsMockListSize() {
        when(list.size()).thenReturn(10);

        assertEquals(10, list.size());
    }

    @Test
    public void letsMockListSizeWithMultipleReturnValues() {
        when(list.size()).thenReturn(10).thenReturn(20);

        assertEquals(10, list.size()); // First Call
        assertEquals(20, list.size()); // Second Call
    }

    @Test
    public void letsMockListGet() {
        when(list.get(0)).thenReturn(INPUT);

        assertEquals(INPUT, list.get(0));
        assertNull(list.get(1));
    }

    @Test(expected = RuntimeException.class)
    public void letsMockListGetToThrowException() {
        when(list.get(anyInt())).thenThrow(new RuntimeException("Something went wrong"));

        list.get(0);
    }

    @Test
    public void letsMockListGetWithAny() {
        when(list.get(anyInt())).thenReturn(INPUT);

        assertEquals(INPUT, list.get(0));
        assertEquals(INPUT, list.get(1));
    }

    @Test
    public void bddAliasesUsingGivenWillReturn() {
        //given
        given(list.get(anyInt())).willReturn(INPUT);

        //then
        assertThat(INPUT, is(list.get(0)));
        assertThat(INPUT, is(list.get(0)));
    }
}
