package com.example.demo.services;

import java.sql.Blob;

import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.example.demo.Model.Anuncio;
import com.example.demo.Model.Usuario;
import com.example.demo.Repository.AnuncioRepository;

public class Service{

	@Autowired
	private AnuncioRepository RepositorioAnuncio;
	
	private Anuncio anuncio;
	private Usuario user;
	

	public int CrearAnuncio (String materia, String contenido, String horario, 
			String precio, String curso) {
		
		user = new Usuario("Profesor", "Sanchez", "Gomez", "12341234", 1, 1, "profesor@gmail.com",1,null);
		
		Anuncio anuncio = new Anuncio(user, materia, contenido, horario,precio,curso);
		
		anuncio = new Anuncio(user, "matematicas", "tema 1", "10 a 14","10 euros","cero");
		RepositorioAnuncio.save(anuncio);
		
		return 1;
	}
	
}
