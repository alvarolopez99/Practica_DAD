package com.example.demo.Controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class TeacherController {

	@GetMapping("/material_subido")
	public String greeting(Model model, @RequestParam String nombre, @RequestParam MultipartFile archivo) {
		
		return "";
	}
	
	
}
