package com.example.demo.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Model.Usuario;

@Controller
public class UserController {
	
	@GetMapping("/profile")
	public String editUser(Model model, HttpSession session) {
		
		//Leer usuario actual del httpsession
		/*
		Usuario user = (Usuario)sesion.getAttribute("user");
		*/
		
		//Inicializacion de usuario provisional
		Usuario user = new Usuario("Pablo", "Bayona", "González", "contraseña123", 0, 0, "correo@correo.es", 0, null);
		
		
		model.addAttribute("usuario", user);
		
		if(user.getTipoSuscripcion()==0){
			model.addAttribute("tipoSuscripcion", "Estándar");
		}
		else {
			model.addAttribute("tipoSuscripcion", "Premium");
		}
		
		if(user.getTipoUsuario()==0){
			model.addAttribute("tipoUsuario", "Alumno");
		}
		else {
			model.addAttribute("tipoUsuario", "Profesor");
		}
		
		return "editarperfil";
	}
}
