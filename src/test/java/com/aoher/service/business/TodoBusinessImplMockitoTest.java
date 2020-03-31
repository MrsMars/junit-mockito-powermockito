package com.aoher.service.business;

import com.aoher.service.TodoBusiness;
import com.aoher.service.TodoService;
import com.aoher.service.impl.TodoBusinessImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class TodoBusinessImplMockitoTest {

    private static final String INPUT = "RANGA";
    private static List<String> allTodo;

    private TodoService todoService;
    private TodoBusiness todoBusiness;

    @BeforeClass
    public static void setUp() {
        allTodo = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
    }

    @Before
    public void init() {
        this.todoService = mock(TodoService.class);
        this.todoBusiness = new TodoBusinessImpl(todoService);
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
        List<String> todo = todoBusiness.retrieveTodoRelatedToSpring(INPUT);

        //then
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
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        when(todoService.retrieveTodo(INPUT)).thenReturn(allTodo);

        todoBusiness.deleteTodoNotRelatedToSpring(INPUT);

        verify(todoService).deleteTodo(argumentCaptor.capture());
        assertEquals(allTodo.get(2), argumentCaptor.getValue());
    }
}
