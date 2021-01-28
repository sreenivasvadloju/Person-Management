package com.mars.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionController {
	
	public static final String INTERNAL_ERROR="No Users found in the System";
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {
		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("errMsg",INTERNAL_ERROR);
		return model;

	}
	
}