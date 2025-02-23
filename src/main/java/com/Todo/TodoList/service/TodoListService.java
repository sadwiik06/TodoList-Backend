package com.Todo.TodoList.service;

import com.Todo.TodoList.model.TodoList;
import com.Todo.TodoList.repository.TodoListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListService {
    @Autowired
    private TodoListRepo repo;

    public List<TodoList> getTodoList() {
        return repo.findAll();
    }

    public TodoList getTodo(long todoId) {
        return repo.findById(todoId).orElse(new TodoList()); // Returns empty TodoList if not found
    }

    public void addTodo(TodoList todo) {
        repo.save(todo);
    }

    public boolean updateTodo(long todoId, TodoList updatedTodo) {
        return repo.findById(todoId).map(existingTodo -> {
            existingTodo.setTitle(updatedTodo.getTitle());
            existingTodo.setDescription(updatedTodo.getDescription());
            existingTodo.setCompleted(updatedTodo.isCompleted());
            repo.save(existingTodo);
            return true;
        }).orElse(false); // Return false if not found
    }

    public boolean deleteTodo(long todoId) {
        if (repo.existsById(todoId)) {
            repo.deleteById(todoId);
            return true; // Deleted successfully
        }
        return false; // ID not found
    }
}
