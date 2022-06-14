package com.pichincha.demo.exception.Exception;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class BadRequestException extends RuntimeException {

	public BadRequestException() {	
	}
	
	public BadRequestException(String message) {	
		super(message);
	}
	
	
	
	

}
