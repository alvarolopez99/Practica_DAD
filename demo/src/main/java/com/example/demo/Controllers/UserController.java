package com.example.demo.Controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.Blob;

import javax.servlet.http.HttpSession;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Model.Usuario;
import com.example.demo.Model.Curso;
import com.example.demo.Model.Examen;
import com.example.demo.Model.Pregunta;
import com.example.demo.Repository.CursoRepository;
import com.example.demo.Repository.ExamenRepository;
import com.example.demo.Repository.UsuarioRepository;
import com.example.demo.services.MailService;


@Controller
public class UserController {
	
	@Autowired
	UsuarioRepository userRepo;
	@Autowired
	ExamenRepository examRepo;
	@Autowired
	CursoRepository cursoRepo;
	
	@Autowired
	MailService mail;
	
	@GetMapping("/profile")
	public String editUser(Model model, HttpSession sesion) throws SQLException, IOException, ClassNotFoundException {
		
		//Leer usuario actual del httpsession
		
		Usuario user = (Usuario)sesion.getAttribute("user");
		Blob foto = user.getFotoPerfil();
		byte[] bdata = foto.getBytes(1, (int) foto.length());
		String s = java.util.Base64.getEncoder().encodeToString(bdata);
		
		
		//Inicializacion de usuario provisional
		//Usuario user = new Usuario("Pablo", "Bayona", "González", "contraseña123", 0, 0, "correo@correo.es", 0, null);
		
		if (user != null) {
			model.addAttribute("hayUsuario", true);
			model.addAttribute("usuario", user);
			
			if(user.getTipoSuscripcion()==0){
				model.addAttribute("tipoSuscripcion", "Estándar");
			}
			else {
				model.addAttribute("tipoSuscripcion", "Premium");
			}
			
			if(user.getTipoUsuario()==0){
				model.addAttribute("tipoUsuario", "Alumno");
			}
			else {
				model.addAttribute("tipoUsuario", "Profesor");
			}
			
			model.addAttribute("imagen", s);

		} else {
			
			model.addAttribute("hayUsuario", false);
		}
		
		
		
		return "editarperfil";
	}
	
	@GetMapping("/deleteUser")
	public String deleteUser(Model model, HttpSession session) {
		
		//Leer usuario actual del httpsession
		
		Usuario user = (Usuario)session.getAttribute("user");
		userRepo.delete(user);
		session.setAttribute("user", null);
		
		
		
		model.addAttribute("mensaje", "Se ha eliminado correctamente al usuario");
		return "usuarioModificado";
	}
	
	@PostMapping("/modifyUser")
	public String modifyUser(Model model, HttpSession session, @RequestParam String nombreUsuario, @RequestParam String apellido1,
			@RequestParam String apellido2/*, @RequestParam MultipartFile image*/) throws IOException{
		
		//Leer usuario actual del httpsession

		/*Usuario user = (Usuario)session.getAttribute("user");
		
		if(!nombreUsuario.equals("")) user.setNombre(nombreUsuario);
		if(!apellido1.equals("")) user.setPrimerApellido(apellido1);
		if(!apellido2.equals("")) user.setSegundoApellido(apellido2);
		
		if(image!=null) user.setFotoPerfil(BlobProxy.generateProxy(image.getInputStream(), image.getSize()));
		
		
		
		userRepo.save(user);
		session.setAttribute("user", user);*/
		

		model.addAttribute("mensaje", "Se han modificado correctamente tus datos");
		return "usuarioModificado";
	}
	
	List<Pregunta> preguntas = new ArrayList<Pregunta>();
	@GetMapping("/{curso}/examen")
	public String hacerExamen(Model model, @PathVariable String curso){
		
		
		preguntas.add(new Pregunta("¿Patata frita?", "Si"));
		preguntas.add(new Pregunta("¿En qué continente está España?", "Europa"));
		preguntas.add(new Pregunta("¿En qué continente está España?", "Europa"));
		preguntas.add(new Pregunta("¿En qué continente está España?", "Europa"));
		preguntas.add(new Pregunta("¿En qué continente está España?", "Europa"));
		
		model.addAttribute("curso", curso);
		model.addAttribute("preguntas", preguntas);
		return "resolverExamen";
	}
	
	@PostMapping("/{curso}/examen/completado")
	public String completarExamen(Model model, @RequestParam String resp1, @RequestParam String resp2, @RequestParam String resp3,
			@RequestParam String resp4, @RequestParam String resp5, HttpSession session, @PathVariable String curso){
		
		List<String> respuestas = new ArrayList<String>();
		respuestas.add(resp1);
		respuestas.add(resp2);
		respuestas.add(resp3);
		respuestas.add(resp4);
		respuestas.add(resp5);
		
		int i = 0;
		int puntuacion = 0;
		for(Pregunta p: preguntas){
			if(p.getRespuesta().equalsIgnoreCase(respuestas.get(i))) {
				puntuacion++;
			}
			i++;
		}
		
		if(puntuacion >= 3) {
			Usuario u = (Usuario)session.getAttribute("user");
			
			//Provisional
			u = new Usuario();
			u.setCorreo("urjc.fower@gmail.com");			
			
			/******/
			
			String contenido = "Enhorabuena. Has completado con éxito el curso "+ curso+"disponible en la plataforma Sapiotheca";
			mail.sendEmail(u.getCorreo(), "Certificado "+curso, contenido);
			model.addAttribute("mensaje","Has obtenido una puntuación de "+puntuacion+"/5");
			model.addAttribute("mensaje2", "¡Enhorabuena por completar el curso!");
		}
		else {
			model.addAttribute("mensaje","Has obtenido una puntuación de "+puntuacion+"/5");
			model.addAttribute("mensaje2", "Sigue intentándolo para obtener tu certificado");
		}
		
		return "examenCompletado";
	}
	
	@GetMapping("/{curso}/crearexamen")
	public String crearExamen(Model model, @PathVariable String curso){
		
		model.addAttribute("curso", curso);
		
		return "crearExamen";
	}
	
	@PostMapping("/{curso}/examencreado")
	public String creadoExamen(Model model, @RequestParam String resp1, @RequestParam String resp2, @RequestParam String resp3,
			@RequestParam String resp4, @RequestParam String resp5, HttpSession session, @PathVariable String curso,
			@RequestParam String preg1, @RequestParam String preg2, @RequestParam String preg3,
			@RequestParam String preg4, @RequestParam String preg5){
		
		/*Examen m = new Examen();	//Crear y guardar nuevo examen
		m.addPregunta(new Pregunta(preg1, resp1));
		m.addPregunta(new Pregunta(preg2, resp2));
		m.addPregunta(new Pregunta(preg3, resp3));
		m.addPregunta(new Pregunta(preg4, resp4));
		m.addPregunta(new Pregunta(preg5, resp5));*/
		
		//Base de datos
		/*Optional<Curso> c = cursoRepo.findByTitulo(curso);
		if(c.isPresent()) {
			m.setCurso(c.get());	//Lo asocia con el curso concreto
			
			Optional<Examen> examenActual = examRepo.findByCurso(c.get().getId());
			
			if(examenActual.isPresent()) {
				examRepo.delete(examenActual.get());
			}
		}
		
		
		
		examRepo.save(m);*/
		
		model.addAttribute("curso", curso);
		model.addAttribute("mensaje", "Se ha creado el exámen con éxito");
		return "examenCreado";
	}
}
