package com.abolkog.springboot_essat.todo_api.error;

import org.springframework.http.HttpStatus;

public class ConflictException extends ApiBaseException{

	public ConflictException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HttpStatus getStatusCode() {
		// TODO Auto-generated method stub
		return HttpStatus.CONFLICT;
	}

}
