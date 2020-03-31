package com.aoher.service.impl;

import com.aoher.service.TodoBusiness;
import com.aoher.service.TodoService;

import java.util.List;
import java.util.stream.Collectors;

public class TodoBusinessImpl implements TodoBusiness {

    public static final String SPRING = "Spring";

    private TodoService todoService;

    public TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    @Override
    public List<String> retrieveTodoRelatedToSpring(String user) {
        List<String> allTodo = getAllTodo(user);
        return allTodo.stream()
                .filter(todo -> todo.contains(SPRING))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTodoNotRelatedToSpring(String user) {
        List<String> allTodo = getAllTodo(user);
        allTodo.stream()
                .filter(todo -> !todo.contains(SPRING))
                .forEach(todo -> todoService.deleteTodo(todo));
    }

    private List<String> getAllTodo(String user) {
        return todoService.retrieveTodo(user);
    }
}
