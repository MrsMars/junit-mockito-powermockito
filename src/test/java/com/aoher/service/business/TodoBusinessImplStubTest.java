package com.aoher.service.business;

import com.aoher.service.TodoService;
import com.aoher.service.data.stub.TodoServiceStub;
import com.aoher.service.impl.TodoBusinessImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TodoBusinessImplStubTest {

    @Test
    public void usingAStub() {
        TodoService todoService = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        List<String> todo = todoBusinessImpl.retrieveTodoRelatedToSpring("Ranga");

        assertEquals(2, todo.size());
    }
}
