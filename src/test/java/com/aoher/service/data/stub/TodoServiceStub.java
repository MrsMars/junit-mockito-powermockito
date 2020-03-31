package com.aoher.service.data.stub;

import com.aoher.service.TodoService;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {

    @Override
    public List<String> retrieveTodo(String user) {
        return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
    }

    @Override
    public void deleteTodo(String todo) {
        // empty
    }
}
