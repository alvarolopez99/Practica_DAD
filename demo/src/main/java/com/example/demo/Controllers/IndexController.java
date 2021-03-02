package com.example.demo.Controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Foros;
import java.util.ArrayList;
import java.util.List;



@Controller
public class IndexController {
	
	private List<Foros> foros = new ArrayList<>();
	
	public IndexController () {		
		foros.add(new Foros("PRUEBA", "DE", "FORO"));		
	}
	
	@GetMapping("/foros")
	public String MostrarForos (Model model) {
		
		model.addAttribute("foros", foros);
		
		return "Foros";
	}
	
	@GetMapping("/")
	public String indexMain(Model model) {
		return "index.html";
	}
	
	@GetMapping("/login")
	public String loginMain(Model model) {
		return "formulario_login";
	}
	
	@GetMapping("/newuser")
	public String newuserMain(Model model) {
		return "formulario_newuser";
	}
	
	@PostMapping("/bienvenido")
	public String bienvenido(Model model, @RequestParam String correo /*,@RequestParam String contraseña*/) {
		model.addAttribute("correo", correo);
		//model.addAttribute("contraseña", contraseña);
		
		return "bienvenido";
	}
	
	@GetMapping("/iniciada")
	public String sesionIniciadaMain(Model model, @RequestParam String nombreUsuario) {
		
		
		model.addAttribute("name", nombreUsuario);
		
		return "iniciada";
	}
	
	@GetMapping("/anuncios")
	public String anuncios(Model model) {
		
		
		return "Anuncios";
	}
	
	
	@GetMapping("/anuncios/{idAnuncio}")
	public String anuncio(Model model, @PathVariable String idAnuncio) {
		
		model.addAttribute("infoProfesor", idAnuncio);
		model.addAttribute("nombreProfesor", "Nombre del profesor");
		
		return "Anuncio";
	}
}
