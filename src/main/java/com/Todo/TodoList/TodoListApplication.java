package com.Todo.TodoList;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoListApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load(); // Load .env file

		System.setProperty("DB_URL", dotenv.get("DB_URL"));
		System.setProperty("DB_USER", dotenv.get("DB_USER"));
		System.setProperty("DB_PASS", dotenv.get("DB_PASS"));
		SpringApplication.run(TodoListApplication.class, args);
	}

}
