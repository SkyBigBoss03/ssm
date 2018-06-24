package com.jt.controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@ControllerAdvice
public class GlobalExceptionHandler {
	   @ExceptionHandler(IllegalArgumentException.class)
	   @ResponseBody
	   public String handleArgumentException(
			   IllegalArgumentException e){
		   return e.getMessage();
	   }
}
