package com.abolkog.springboot_essat.todo_api.todos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
	@Autowired
	private TodoRepository todoRepository;
	

	
	public List<Todo> findAll(){
		    return todoRepository.findAll();
			
	}

	public Todo getById(String id) {
		// TODO Auto-generated method stub
		return todoRepository.findById(id).get();
	}
	public Todo save(Todo todo) {
		return todoRepository.insert(todo);
		
	}
	public void delete(String id) {
    todoRepository.deleteById(id);
		
		
	}

}
