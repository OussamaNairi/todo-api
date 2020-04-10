package com.abolkog.springboot_essat.todo_api.todos;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping(value = {"","/"})
	public ResponseEntity<List<Todo>> getAllTodos() {
		List<Todo> result = todoService.findAll();
		return new ResponseEntity<List<Todo>>(result,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Todo> getTodoById(@PathVariable String id) {
		
		Todo result= todoService.getById(id);
		return new ResponseEntity<Todo>(result,HttpStatus.OK);
	}
	@PostMapping(value = {"","/"})
    public ResponseEntity<Todo> createNewTodo(@Valid @RequestBody Todo todo) {
    	Todo result = todoService.save(todo);
    	return new ResponseEntity<Todo>(result,HttpStatus.CREATED);
    	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String id) {
		todoService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
    }

