package com.example.demo.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckLoginController {
	@PostMapping("/checkLogin")
	public String comprobarLogin(Model model, @RequestParam String nombre, @RequestParam String contraseña) {		
	
		String url = "Error_Login";
		
		/* COMENTADO HASTA INTRODUCIR BBDD
		Optional<Usuario> usuario = usuario.findByName(nombre);
		
		if(usuario.isPresent()) {
			
			if (contraseña == usuario.getContraseña()) {
				url = "Sesion_Iniciada_Template";
			} else {
				String error = "Contraseña errónea";
				model.addAttribute("mensajeError", error);
			}
			
		} else {
			String error = "Nombre de usuario erróneo";
			model.addAttribute("mensajeError", error);
		}
		
		*/
		
		return url;
	}
	
	@GetMapping("/iniciada")
	public String sesionIniciada(Model model) {
			
		return "";
	}
}
