package com.abolkog.springboot_essat.todo_api.todos;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	public List<Todo> data=Arrays.asList(
		     new Todo(1,"First Todo","Do my homework"),
		     new Todo(2,"Second Todo","Do my homework"),
		     new Todo(3,"Third Todo","Do my homework"),
		     new Todo(4,"Fourth Todo","Do my homework"),
		     new Todo(5,"Fifth Todo","Do my homework")
			
			);
	
	public List<Todo> findAll(){
		    return data;
			
	}

	public Todo getById(int id) {
		// TODO Auto-generated method stub
		for(Todo todo:data) {
			
			if (todo.getId()==id) return todo;
		}
		return null;
	}

}
