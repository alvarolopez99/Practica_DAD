package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import com.example.demo.Model.Anuncio;
import com.example.demo.Model.Curso;
import com.example.demo.Model.Foros;
import com.example.demo.Model.Mensaje;
import com.example.demo.Model.Usuario;
import com.example.demo.Repository.AnuncioRepository;
import com.example.demo.Repository.ChatRepository;
import com.example.demo.Repository.CursoRepository;
import com.example.demo.Repository.ForosRepository;
import com.example.demo.Repository.MensajeRepository;
import com.example.demo.Repository.PostRepository;
import com.example.demo.Repository.PreguntaRepository;
import com.example.demo.Repository.UsuarioRepository;

@Controller
public class Uso_BD implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuario_repository;
	@Autowired
	private AnuncioRepository anuncio_repository;

	@Autowired
	private ForosRepository foros_repository;
	@Autowired
	private ChatRepository char_repository;
	@Autowired
	private CursoRepository curso_repository;
	@Autowired
	private MensajeRepository mensaje_repository;
	@Autowired
	private PostRepository post_repository;
	@Autowired
	private PreguntaRepository pregunta_repository;
	@Autowired
	
	
	@Override
	public void run(String... args) throws Exception {

		
		// Usuarios	
		Usuario alumno1 = new Usuario("Alvaro", "Lopez", "Sierra", "pass1", 0, 0, "correo1", 1, null);
		Usuario alumno2 = new Usuario("Pablo", "Bayona", "Gonzalez", "pass2", 0, 1, "correo2", 0, null);
		Usuario profesor1 = new Usuario("Carlos", "Garre", "del Olmo", "pass3", 1, 0, "correo3", 0, null);
		Usuario profesor2 = new Usuario("David", "Ortega", "del Campo", "pass4", 1, 0, "correo4", 0, null);
		Usuario profesor_ClasesParticulares1 = new Usuario("Carlos", "Colmenero", "Gómez", "pass5", 1, 0, "correo5", 0, null);
		Usuario profesor_ClasesParticulares2 = new Usuario("Angel", "Garcia", "Collado", "pass6", 1, 0, "correo6", 0, null);
		
		usuario_repository.save(alumno1);
		usuario_repository.save(alumno2);
		usuario_repository.save(profesor1);
		usuario_repository.save(profesor2);
		usuario_repository.save(profesor_ClasesParticulares1);
		usuario_repository.save(profesor_ClasesParticulares2);
		
		
		// Cursos
		Curso curso_Realidad_Virtual = new Curso("Realidad Virtual",  "Clases de Realidad Virtual");
		Curso curso_Animacion_3D = new Curso("Animación 3D", "Clases de Animación 3D");
		
		curso_repository.save(curso_Realidad_Virtual);
		curso_repository.save(curso_Animacion_3D);
		
		
		// Anuncios
		Anuncio clases_Particulares_1 = new Anuncio(profesor_ClasesParticulares1, "Clases particulares de matemáticas", "Ofrezco clases de matemáticas a buen precio", "17:00 - 19:00", "60€/hora", "Curso Matemáticas");
		Anuncio clases_Particulares_2 = new Anuncio(profesor_ClasesParticulares2, "Clases particulares de literatura", "Ofrezco clases de literatura a buen precio", "19:00 - 21:00", "120€/hora", "Curso Literatura");
		
		anuncio_repository.save(clases_Particulares_1);
		anuncio_repository.save(clases_Particulares_2);
		
		
		// Foros
		Foros foro_Coches = new Foros("Foro sobre coches", "Los coches son muy complejos");
		Foros foro_Flores = new Foros("Foro sobre flores", "Las flores huelen a rosa");
		
		foros_repository.save(foro_Coches);
		foros_repository.save(foro_Flores);
		
		
		// Mensajes
		Mensaje saludar_Alumno1 = new Mensaje(alumno1, "Hola alumno1");
		Mensaje saludar_Alumno2 = new Mensaje(alumno2, "Hola alumno2");
		
		mensaje_repository.save(saludar_Alumno1);
		mensaje_repository.save(saludar_Alumno2);
		
		
		
		/*
		// Imprimir usuarios
		List<Usuario> usuarios = usuario_repository.findAll();
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Usuario u : usuarios) {
			System.out.println(u);
		}
		System.out.println();

		// Imprimir usuarios por ID
		Usuario u = usuario_repository.findById(1L).get();
		System.out.println("Customer found with findOne(1L):");
		System.out.println("--------------------------------");
		System.out.println(u);
		System.out.println();

		// fetch customers by last name
		Optional<Usuario> bauers = usuario_repository.findByNombre("Pablo");
		System.out.println("Customer found with findByNombre('Pablo'):");
		System.out.println("--------------------------------------------");
		
		for (Usuario bauer : bauers) {
			System.out.println(bauer);
		}
		System.out.println(bauers.get());
		//usuario_repository.delete(bauers.get(0));
		
		*/
		
	}
}