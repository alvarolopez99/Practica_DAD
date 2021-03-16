package com.example.demo.Controllers;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Anuncio;
import com.example.demo.Model.Usuario;
import com.example.demo.Repository.AnuncioRepository;

@Controller
public class AnuncioController {

	@Autowired 
	private AnuncioRepository repositorioAnuncios;
	
	@GetMapping("/anuncios")
	public String anuncios(Model model) {
		
	
		if (repositorioAnuncios.findAll() != null) {
			model.addAttribute("anuncios",  repositorioAnuncios.findAll());
		}

		return "Anuncios/Anuncios";
	}	
	
	@GetMapping("/crearAnuncio")
	public String crearAnuncio(Model model) {
		
		return "Anuncios/formulario_crear_anuncio";
		
	}
	
	
	@PostMapping("/anuncioCreado")
	public String anuncioCreado(Model model, @RequestParam String materia, @RequestParam String curso, 
			@RequestParam String horario, @RequestParam String precio, @RequestParam String contenido, HttpSession session) {
		
		Usuario user = (Usuario)session.getAttribute("user");
		Anuncio anuncio = new Anuncio(user, materia, contenido, horario, precio, curso);
		repositorioAnuncios.save(anuncio);
		
		
		return "Anuncios/anuncio_creado";
	}
	
	@GetMapping("/anuncios/{IDAnuncio}")
	public String anuncio(Model model, @PathVariable int IDAnuncio) {
		
		
		Optional<Anuncio> anuncio = repositorioAnuncios.findById(IDAnuncio);
		
		 if (anuncio.isPresent()) {
				model.addAttribute("infoAnuncio",anuncio.get());
		 }
		
		return "Anuncios/Anuncio";
	}
	
	@GetMapping("/eliminarAnuncio/{index}")
	public String eliminarAnuncio(Model model, @PathVariable int index) {
		
		
		repositorioAnuncios.deleteById(index);

		return "Anuncios/anuncio_eliminado";
	}
	
}
