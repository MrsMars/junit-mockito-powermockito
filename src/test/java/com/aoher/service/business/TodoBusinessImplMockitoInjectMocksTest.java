package com.aoher.service.business;

import com.aoher.service.TodoService;
import com.aoher.service.impl.TodoBusinessImpl;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoInjectMocksTest {

    private static final String INPUT = "Ranga";
    private static List<String> allTodo;

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
        //given
        given(todoService.retrieveTodo(INPUT)).willReturn(allTodo);

        //when
        List<String> todos = todoBusiness.retrieveTodoRelatedToSpring(INPUT);

        //then
        assertThat(todos.size(), is(2));
    }

    @Test
    public void letsTestDeleteNow() {
        when(todoService.retrieveTodo(INPUT)).thenReturn(allTodo);

        todoBusiness.deleteTodoNotRelatedToSpring(INPUT);

        verify(todoService).deleteTodo(allTodo.get(2));
        verify(todoService, never()).deleteTodo(allTodo.get(1));
        verify(todoService, never()).deleteTodo(allTodo.get(0));
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
