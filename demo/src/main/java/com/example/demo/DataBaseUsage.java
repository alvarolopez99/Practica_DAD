package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import com.example.demo.Model.Usuario;

@Controller
public class DataBaseUsage implements CommandLineRunner {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public void run(String... args) throws Exception {

		// save a couple of customers
		repository.save(new Usuario("Alvaro", "Lopez", "Sierra", 0, 0, "correo", 0, null));
		repository.save(new Usuario("Pablo", "Bayona", "Gonzalez", 0, 0, "correo2", 0, null));


		// fetch all customers
		List<Usuario> usuarios = repository.findAll();
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Usuario u : usuarios) {
			System.out.println(u);
		}
		System.out.println();

		// fetch an individual customer by ID
		Usuario u = repository.findById(1L).get();
		System.out.println("Customer found with findOne(1L):");
		System.out.println("--------------------------------");
		System.out.println(u);
		System.out.println();

		// fetch customers by last name
		List<Usuario> bauers = repository.findByNombre("Pablo");
		System.out.println("Customer found with findByNombre('Pablo'):");
		System.out.println("--------------------------------------------");
		for (Usuario bauer : bauers) {
			System.out.println(bauer);
		}

		repository.delete(bauers.get(0));
	}
}
