package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

	@GetMapping("/")
	public String indexMain(Model model) {
		return "index.html";
	}
	
	@GetMapping("/cursos")
	public String cursosMain(Model model) {
		return "cursos_main";
	}
	
	@GetMapping("/profesores")
	public String profesoresMain(Model model) {
		return "profesores_main";
	}
	
	@GetMapping("/iniciada")
	public String sesionIniciadaMain(Model model, @RequestParam String nombreUsuario) {
		
		
		model.addAttribute("name", nombreUsuario);
		
		return "iniciada";
	}
	
}
