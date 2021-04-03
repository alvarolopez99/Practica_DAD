package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class DefaultModelAttributes {
	@ModelAttribute("profesor")
	public boolean profesor(HttpServletRequest request) {
		return request.isUserInRole("profesor"); 
	}
}
