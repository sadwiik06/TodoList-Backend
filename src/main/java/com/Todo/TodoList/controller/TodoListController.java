package com.Todo.TodoList.controller;

import com.Todo.TodoList.model.TodoList;
import com.Todo.TodoList.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos") // Common base path for all endpoints
public class TodoListController {
    @Autowired
    private TodoListService service;

    @GetMapping("/")
    public ResponseEntity<List<TodoList>> getTodoList() {
        List<TodoList> todos = service.getTodoList();
        return ResponseEntity.ok(todos); // 200 OK
    }

    @GetMapping("/{todo_id}")
    public ResponseEntity<TodoList> getTodo(@PathVariable long todo_id) {
        TodoList todo = service.getTodo(todo_id);
        if (todo.getId() == 0) {
            return ResponseEntity.notFound().build(); // 404 Not Found if no todo exists
        }
        return ResponseEntity.ok(todo);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addTodo(@RequestBody TodoList todo) {
        service.addTodo(todo);
        return ResponseEntity.ok("To-Do added successfully!"); // 200 OK
    }

    @PutMapping("/update/{todo_id}")
    public ResponseEntity<String> updateTodo(@PathVariable long todo_id, @RequestBody TodoList updatedTodo) {
        boolean updated = service.updateTodo(todo_id, updatedTodo);
        if (updated) {
            return ResponseEntity.ok("To-Do updated successfully!");
        } else {
            return ResponseEntity.notFound().build(); // 404 if ID doesn't exist
        }
    }

    @DeleteMapping("/delete/{todo_id}")
    public ResponseEntity<String> deleteTodo(@PathVariable long todo_id) {
        boolean deleted = service.deleteTodo(todo_id);
        if (deleted) {
            return ResponseEntity.ok("To-Do deleted successfully!");
        } else {
            return ResponseEntity.notFound().build(); // 404 if ID not found
        }
    }
}
