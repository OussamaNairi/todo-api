package com.abolkog.springboot_essat.todo_api.todos;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping(value = {"","/"})
	public List<Todo> getAllTodos() {
		return todoService.findAll();
	}
	@GetMapping("/{id}")
	public Todo getTodoById(@PathVariable int id) {
		
		return todoService.getById(id);
	}

}
