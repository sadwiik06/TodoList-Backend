package com.Todo.TodoList.repository;

import com.Todo.TodoList.model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepo extends JpaRepository<TodoList,Long> {
}
