package com.abolkog.springboot_essat.todo_api.todos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.test.context.junit4.SpringRunner;
import org.mockito.BDDMockito;
import static org.mockito.BDDMockito.*;

import java.util.List;
import java.util.Arrays;
import java.util.Optional;



import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
public class TodoServiceTest {
	@MockBean
	private TodoRepository todoRepository;
	
	@Autowired
	private TodoService todoService;
	@TestConfiguration
	static class TodoServiceContextConfiguration{
		@Bean
		public TodoService todoService() {
			return new TodoService();
		}
		
	}
	@Test
	public void WhenFindAll_ReturnTodoList() {
		Todo todo1 = new Todo("1","Todo 1","Todo 1");
		Todo todo2 = new Todo("2","Todo 2","Todo 2");
		List<Todo> data =Arrays.asList(todo1,todo2);
		given(todoRepository.findAll()).willReturn(data);
		assertThat(todoService.findAll()).hasSize(2).contains(todo1,todo2);
		
	}
	@Test
	public void WhenGetById_TodoShouldBeFound() {
		Todo todo = new Todo("1","Todo 1","Todo 1");
		given(todoRepository.findById(anyString())).willReturn(Optional.ofNullable(todo));
		Todo result =todoService.getById("1");
		assertThat(result.getTitle()).containsIgnoringCase("todo");
		
	}
	@Test(expected = NotFoundException.class)
	public void WhenInvalidId_TodoShouldNotBeFound() {
		
		given(todoRepository.findById(anyString())).willReturn(Optional.empty());
		todoService.getById("1");
		
		
	}

}
