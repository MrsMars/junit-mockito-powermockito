package com.aoher.service;

import java.util.List;

public interface TodoBusiness {

    List<String> retrieveTodoRelatedToSpring(String user);
    void deleteTodoNotRelatedToSpring(String user);
}
