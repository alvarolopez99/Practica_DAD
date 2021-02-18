package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Homepage {
	
	
	/*Este método tiene que invocarse cuando se llame a la URL de homepage*/
	
	@GetMapping("/") //Podemos especificar cualquier html
	public String helloUser() {
		
		return "hello-user.html";

	}
	

}
