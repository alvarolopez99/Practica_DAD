package com.example.demo.Controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class CheckLoginController {
	@GetMapping("/checkLogin")
	public String greeting(Model model, @RequestParam String nombreUsuario, @RequestParam String contraseña) {		
		/*
		 * Comprobar nombreUsuario y contraseña en la BBDD
		 */
		return "sesion_Iniciada_Template";
	}
}
