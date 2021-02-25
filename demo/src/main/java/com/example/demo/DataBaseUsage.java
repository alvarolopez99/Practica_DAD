package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import com.example.demo.Model.Anuncio;
import com.example.demo.Model.Usuario;
import com.example.demo.Repository.AnuncioRepository;
import com.example.demo.Repository.UsuarioRepository;

@Controller
public class DataBaseUsage implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuario_repository;
	@Autowired
	private AnuncioRepository anuncio_repository;

	@Override
	public void run(String... args) throws Exception {

		// save a couple of customers
		usuario_repository.save(new Usuario("Alvaro", "Lopez", "Sierra", "pass1", 0, 0, "correo", 0, null));
		usuario_repository.save(new Usuario("Pablo", "Bayona", "Gonzalez", "pass2", 0, 0, "correo2", 0, null));
		
		anuncio_repository.save(new Anuncio("contenido1"));
		anuncio_repository.save(new Anuncio("contenido2"));

		// fetch all customers
		List<Usuario> usuarios = usuario_repository.findAll();
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Usuario u : usuarios) {
			System.out.println(u);
		}
		System.out.println();

		// fetch an individual customer by ID
		Usuario u = usuario_repository.findById(1L).get();
		System.out.println("Customer found with findOne(1L):");
		System.out.println("--------------------------------");
		System.out.println(u);
		System.out.println();

		// fetch customers by last name
		/*List<Usuario> bauers = usuario_repository.findByNombre("Pablo");
		System.out.println("Customer found with findByNombre('Pablo'):");
		System.out.println("--------------------------------------------");
		for (Usuario bauer : bauers) {
			System.out.println(bauer);
		}*/

		//usuario_repository.delete(bauers.get(0));
	}
}
