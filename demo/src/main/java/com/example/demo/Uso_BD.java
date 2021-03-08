package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import com.example.demo.Model.Anuncio;
import com.example.demo.Model.Chat;
import com.example.demo.Model.Curso;
import com.example.demo.Model.Examen;
import com.example.demo.Model.Foros;
import com.example.demo.Model.Mensaje;
import com.example.demo.Model.Pregunta;
import com.example.demo.Model.Usuario;
import com.example.demo.Repository.AnuncioRepository;
import com.example.demo.Repository.ChatRepository;
import com.example.demo.Repository.CursoRepository;
import com.example.demo.Repository.ExamenRepository;
import com.example.demo.Repository.ForosRepository;
import com.example.demo.Repository.MensajeRepository;
import com.example.demo.Repository.PostRepository;
import com.example.demo.Repository.PreguntaRepository;
import com.example.demo.Repository.UsuarioRepository;
import com.mysql.cj.jdbc.Blob;

@Controller
public class Uso_BD{

	@Autowired
	private UsuarioRepository usuario_repository;
	@Autowired
	private AnuncioRepository anuncio_repository;
	@Autowired
	private ForosRepository foros_repository;
	@Autowired
	private ChatRepository chat_repository;
	@Autowired
	private CursoRepository curso_repository;
	@Autowired
	private MensajeRepository mensaje_repository;
	@Autowired
	private PostRepository post_repository;
	@Autowired
	private PreguntaRepository pregunta_repository;
	@Autowired
	private ExamenRepository examen_repository;
	
	/*public void guardarUsuario(String nombre, String primerApellido, String segundoApellido, String correo, String contraseña, int tipoSuscripcion, 
			int tipoUsuario, int metodoPago, Blob fotoPerfil) {
		usuario_repository.save(new Usuario(nombre, "lopez", "sierra", contraseña, 0, 0, correo, 0, fotoPerfil));
	}*/
	

	public void llamada() {
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
		Curso curso_Realidad_Virtual = new Curso("Realidad Virtual",  "Clases de Realidad Virtual", profesor1);
		Curso curso_Animacion_3D = new Curso("Animación 3D", "Clases de Animación 3D", profesor2);
		
		curso_Realidad_Virtual.AñadirAlumno(alumno1);
		curso_Realidad_Virtual.AñadirAlumno(alumno2);
		curso_Animacion_3D.AñadirAlumno(alumno2);
		
		
		// Anuncios
		Anuncio clases_Particulares_1 = new Anuncio(profesor_ClasesParticulares1, "Clases particulares de matemáticas", "Ofrezco clases de matemáticas a buen precio", "17:00 - 19:00", "60€/hora", "Curso Matemáticas");
		Anuncio clases_Particulares_2 = new Anuncio(profesor_ClasesParticulares2, "Clases particulares de literatura", "Ofrezco clases de literatura a buen precio", "19:00 - 21:00", "120€/hora", "Curso Literatura");
		
		anuncio_repository.save(clases_Particulares_1);
		anuncio_repository.save(clases_Particulares_2);
		
		
		// Foros
		Foros foro_Coches = new Foros("Foro sobre coches", "Los coches son muy complejos", alumno1);
		Foros foro_Flores = new Foros("Foro sobre flores", "Las flores huelen a rosa", profesor1);
		
		
		// Mensajes
		Mensaje mensaje_Foro_Coches1 = new Mensaje(alumno2, "Y muy caros");
		Mensaje mensaje_Foro_Coches2 = new Mensaje(profesor_ClasesParticulares1, "Pero muy cómodos");
		Mensaje mensaje_Foro_Flores = new Mensaje(profesor2, "Pero se marchitan pronto");
		
		mensaje_repository.save(mensaje_Foro_Coches1);
		mensaje_repository.save(mensaje_Foro_Coches2);
		mensaje_repository.save(mensaje_Foro_Flores);		
		
		foro_Coches.AñadirMensaje(mensaje_Foro_Coches1);
		foro_Coches.AñadirMensaje(mensaje_Foro_Coches2);
		foro_Flores.AñadirMensaje(mensaje_Foro_Flores);
		
		foros_repository.save(foro_Coches);
		foros_repository.save(foro_Flores);
		
		
		// Chats
		Chat chat1 = new Chat(profesor1, alumno1);
		
		Mensaje chat1_Mensaje2 = new Mensaje(alumno2, "Bien, y tú?");
		chat1.AñadirMensaje(chat1_Mensaje2);
		
		Mensaje chat1_Mensaje3 = new Mensaje(alumno1, "Genial");
		chat1.AñadirMensaje(chat1_Mensaje3);
		
		chat_repository.save(chat1);
			
		
		// Examenes
		Examen curso_Realidad_Virtual_Examen1 = new Examen(curso_Realidad_Virtual);
		Examen curso_Animacion_3DExamen1 = new Examen(curso_Animacion_3D);
		
		
		// Preguntas
		Pregunta curso_Realidad_Virtual_Examen1_p1 = new Pregunta("¿2>3?", "Falso");
		Pregunta curso_Realidad_Virtual_Examen1_p2 = new Pregunta("¿3>2?", "Verdadero");
		Pregunta curso_Animacion_3DExamen1_p2 = new Pregunta("¿2>=2?", "Verdadero");
		
		pregunta_repository.save(curso_Realidad_Virtual_Examen1_p1);
		pregunta_repository.save(curso_Realidad_Virtual_Examen1_p2);
		pregunta_repository.save(curso_Animacion_3DExamen1_p2);
		
		curso_Realidad_Virtual_Examen1.addPregunta(curso_Realidad_Virtual_Examen1_p1);
		curso_Realidad_Virtual_Examen1.addPregunta(curso_Realidad_Virtual_Examen1_p2);
		curso_Animacion_3DExamen1.addPregunta(curso_Animacion_3DExamen1_p2);
		
		examen_repository.save(curso_Realidad_Virtual_Examen1);
		examen_repository.save(curso_Animacion_3DExamen1);
		
		
		curso_Realidad_Virtual.AñadirExamen(curso_Realidad_Virtual_Examen1);
		curso_Realidad_Virtual.AñadirExamen(curso_Animacion_3DExamen1);

		curso_repository.save(curso_Realidad_Virtual);
		curso_repository.save(curso_Animacion_3D);
		
		
		
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
		}*/
		
		
	}
}