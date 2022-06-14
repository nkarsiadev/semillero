package com.pichincha.demo.exception.Exception;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class NotFoundException extends RuntimeException {

	public NotFoundException() {	
	}
	
	public NotFoundException(String message) {	
		super(message);
	}
	
	
	
	

}
