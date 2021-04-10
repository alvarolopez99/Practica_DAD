package com.example.demo.Controllers;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Anuncio;
import com.example.demo.Model.Usuario;
import com.example.demo.Repository.AnuncioRepository;
import com.example.demo.Repository.UsuarioRepository;

@Controller
public class AnuncioController {

	@Autowired 
	private AnuncioRepository repositorioAnuncios;
	
	@Autowired 
	private UsuarioRepository userRep;
	
	@GetMapping("/anuncios")
	public String anuncios(Model model, HttpServletRequest request) {
		
		boolean esUser = request.isUserInRole("PROFESOR");
		
		model.addAttribute("profesor", esUser);
		//model.addAttribute("user", request.isUserInRole("USER"));
		if (repositorioAnuncios.findAll() != null) {
			model.addAttribute("anuncios",  repositorioAnuncios.findAll());
		}

		return "Anuncios/Anuncios";
	}	
	
	@GetMapping("/crearAnuncio")
	public String crearAnuncio(Model model, HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		
		return "Anuncios/formulario_crear_anuncio";
		
	}
	
	
	@PostMapping("/anuncioCreado")
	public String anuncioCreado(Model model, @RequestParam String materia, @RequestParam String curso, 
			@RequestParam String horario, @RequestParam String precio, @RequestParam String contenido/*, HttpSession session*/,
			HttpServletRequest request) {
		
		//Usuario user = (Usuario)session.getAttribute("user");
		
		Principal p = request.getUserPrincipal();
		Optional<Usuario> user = userRep.findByCorreo(p.getName());
		Anuncio anuncio = new Anuncio(user.get(), materia, contenido, horario, precio, curso);
		repositorioAnuncios.save(anuncio);
		
		
		return "Anuncios/anuncio_creado";
	}
	
	@GetMapping("/anuncios/{IDAnuncio}")
	public String anuncio(Model model, @PathVariable int IDAnuncio, HttpServletRequest request) {
		
		model.addAttribute("user", request.isUserInRole("USER"));
		Optional<Anuncio> anuncio = repositorioAnuncios.findById(IDAnuncio);
		
		 if (anuncio.isPresent()) {
				model.addAttribute("infoAnuncio",anuncio.get());
		 }
		
		return "Anuncios/Anuncio";
	}
	
	@GetMapping("/eliminarAnuncio/{IDAnuncio}")
	public String eliminarAnuncio(Model model, @PathVariable int IDAnuncio) {
		
		
		repositorioAnuncios.deleteById(IDAnuncio);

		return "Anuncios/anuncio_eliminado";
	}
	
}
