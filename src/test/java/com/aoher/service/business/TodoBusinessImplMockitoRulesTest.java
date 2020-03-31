package com.aoher.service.business;

import com.aoher.service.TodoService;
import com.aoher.service.impl.TodoBusinessImpl;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class TodoBusinessImplMockitoRulesTest {

    private static final String INPUT = "RANGA";
    private static List<String> allTodo;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private TodoService todoService;

    @InjectMocks
    private TodoBusinessImpl todoBusiness;

    @Captor
    private ArgumentCaptor<String> stringArgumentCaptor;

    @BeforeClass
    public static void setUp() {
        allTodo = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
    }

    @Test
    public void usingMockito() {
        when(todoService.retrieveTodo(INPUT)).thenReturn(allTodo);

        List<String> todo = todoBusiness.retrieveTodoRelatedToSpring(INPUT);

        assertEquals(2, todo.size());
    }

    @Test
    public void usingMockitoUsingBDD() {
        given(todoService.retrieveTodo(INPUT)).willReturn(allTodo);

        List<String> todo = todoBusiness.retrieveTodoRelatedToSpring(INPUT);

        assertEquals(2, todo.size());
    }

    @Test
    public void letsTestDeleteNow() {

        when(todoService.retrieveTodo(INPUT)).thenReturn(allTodo);

        todoBusiness.deleteTodoNotRelatedToSpring(INPUT);

        verify(todoService).deleteTodo(allTodo.get(2));
        verify(todoService, never()).deleteTodo(allTodo.get(0));
        verify(todoService, never()).deleteTodo(allTodo.get(1));
        verify(todoService, times(1)).deleteTodo(allTodo.get(2));
    }

    @Test
    public void captureArgument() {
        when(todoService.retrieveTodo(INPUT)).thenReturn(allTodo);

        todoBusiness.deleteTodoNotRelatedToSpring(INPUT);

        verify(todoService).deleteTodo(stringArgumentCaptor.capture());
        assertEquals(allTodo.get(2), stringArgumentCaptor.getValue());
    }
}
