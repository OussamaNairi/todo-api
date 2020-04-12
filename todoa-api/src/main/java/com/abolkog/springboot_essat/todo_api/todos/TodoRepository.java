package com.abolkog.springboot_essat.todo_api.todos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends MongoRepository<Todo,String>{

	Todo findByTitle(String title);
	
	
}
