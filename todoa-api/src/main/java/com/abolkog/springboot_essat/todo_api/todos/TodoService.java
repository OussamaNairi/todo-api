package com.abolkog.springboot_essat.todo_api.todos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abolkog.springboot_essat.todo_api.error.ConflictException;
import com.abolkog.springboot_essat.todo_api.error.NotFoundException;

@Service
public class TodoService {
	@Autowired
	private TodoRepository todoRepository;
	

	
	public List<Todo> findAll(){
		    return todoRepository.findAll();
			
	}

	public Todo getById(String id) {
		// TODO Auto-generated method stub
		try {return todoRepository.findById(id).get();
		}catch(NoSuchElementException ex) {
			throw new NotFoundException(String.format("No record with the id [%s] was found in our database. ", id));
		}
	}
	public Todo save(Todo todo) {
		if(todoRepository.findByTitle(todo.getTitle()) !=null) {
			throw new ConflictException("Another record with the same title exists");
		}
		return todoRepository.insert(todo);
		
	}
	public void delete(String id) {
    todoRepository.deleteById(id);
		
		
	}

}
