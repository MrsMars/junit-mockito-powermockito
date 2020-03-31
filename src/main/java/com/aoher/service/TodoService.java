package com.aoher.service;

import java.util.List;

public interface TodoService {

    List<String> retrieveTodo(String user);
    void deleteTodo(String todo);
}
