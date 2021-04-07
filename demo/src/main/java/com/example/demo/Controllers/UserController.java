package com.example.demo.Controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.Blob;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
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
import com.example.demo.services.ImageService;
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
	private ImageService imageServ;
	
	@Autowired
	MailService mail;
	
	@GetMapping("/profile")
	public String editUser(Model model, HttpSession sesion,
			HttpServletRequest request) throws SQLException, IOException, ClassNotFoundException {

		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		
		// Leer usuario actual del httpsession

		Usuario user = (Usuario) sesion.getAttribute("user");
		Blob foto = user.getFotoPerfil();

		if (user.getCorreo() == null) {
			return "no_registrado";
		} else {
			model.addAttribute("hayUsuario", true);
			model.addAttribute("usuario", user);

			if (user.getTipoSuscripcion() == 0) {
				model.addAttribute("tipoSuscripcion", "Estándar");
			} else {
				model.addAttribute("tipoSuscripcion", "Premium");
			}

			if (user.getTipoUsuario() == 0) {
				model.addAttribute("tipoUsuario", "Alumno");
				model.addAttribute("esAlumno", "true");
			} else {
				model.addAttribute("tipoUsuario", "Profesor");
				model.addAttribute("esAlumno", "false");
			}

			if (user.getMetodoPago() == 0) {
				model.addAttribute("pago", "Tarjeta de crédito");
			} else {
				model.addAttribute("pago", "Paypal");
			}
			if (foto != null) {
				if (foto.length() > 1) {
					byte[] bdata = foto.getBytes(1, (int) foto.length());
					String s = java.util.Base64.getEncoder().encodeToString(bdata);
					model.addAttribute("imagen", s);
				} else {
					model.addAttribute("imagen", "");
				}
			}else {
				model.addAttribute("imagen", false);
			}
			return "Perfiles/editarperfil";
		}
	}
	
	@GetMapping("/deleteUser")
	public String deleteUser(Model model, HttpSession session) {
		
		//Leer usuario actual del httpsession
		
		Usuario user = (Usuario)session.getAttribute("user");
		userRepo.delete(user);
		session.setAttribute("user", null);
		
		
		
		model.addAttribute("mensaje", "Se ha eliminado correctamente al usuario");
		return "Perfiles/usuarioModificado";
	}
	
	@PostMapping("/modifyUser")
	public String modifyUser(Model model, HttpSession sesion, @RequestParam String nombreUsuario, @RequestParam String apellido1,
			@RequestParam String apellido2, @RequestParam String contraseña_1, @RequestParam MultipartFile image) throws IOException, SQLException{

		
		Usuario user = (Usuario)sesion.getAttribute("user");
		Blob foto = user.getFotoPerfil();
		
		if(!user.getContraseña().equals(contraseña_1)) {
			return "PaginaDeInicio/volver_a_profile";
		}else {		
			if(!nombreUsuario.equals("")) user.setNombre(nombreUsuario);
			if(!apellido1.equals("")) user.setPrimerApellido(apellido1);
			if(!apellido2.equals("")) user.setSegundoApellido(apellido2);
			
			if (!image.isEmpty()) {
				try {					
					byte[] bytes = image.getBytes();
					
					String nombreFoto = image.getOriginalFilename();
					String formatName = nombreFoto.substring(nombreFoto.lastIndexOf(".") + 1);	
					bytes = imageServ.resize(bytes, 200, 200, formatName);
					
					Blob imagen = new javax.sql.rowset.serial.SerialBlob(bytes);
					
					
					String bphoto = java.util.Base64.getEncoder().encodeToString(bytes);
					
					model.addAttribute("imagen", bphoto);
					
					user.setFotoPerfil(imagen);
				}
				catch (Exception exc){
					return "Fallo al establecer la imagen de perfil";
				}
			} else {
				byte[] bdata = foto.getBytes(1, (int) foto.length());
				String s = java.util.Base64.getEncoder().encodeToString(bdata);
				model.addAttribute("imagen", s);
				user.setFotoPerfil(foto);
			}
			
			userRepo.save(user);
			sesion.setAttribute("user", user);
			
	
			model.addAttribute("mensaje", "Se han modificado correctamente tus datos");
			return "Perfiles/usuarioModificado";
		}
	}
	
	@GetMapping("/{curso}/examen")
	public String hacerExamen(Model model, @PathVariable String curso){
		
		
		Curso c = cursoRepo.findById(Long.parseLong(curso));
		model.addAttribute("curso", c.getTitulo());
		model.addAttribute("id", Long.parseLong(curso));
		
		Optional<Examen> e = examRepo.findByCurso(c);
		if(e.isPresent()) {			
			model.addAttribute("preguntas", e.get().getPreguntas());
		}
		
		return "Examenes/resolverExamen";
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
		
		Curso c = cursoRepo.findById(Long.parseLong(curso));
		Optional<Examen> e = examRepo.findByCurso(c);
		
		if(e.isPresent()) {	
			
			for(Pregunta p: e.get().getPreguntas()){			
				
				if(p.getRespuesta().equalsIgnoreCase(respuestas.get(i))) {
					puntuacion++;
					System.out.println("Acierto");
				}
				i++;
			}
			
			if(puntuacion >= 3) {
				Usuario u = (Usuario)session.getAttribute("user");

				String contenido = "Enhorabuena. Has completado con éxito el curso "+ curso+"disponible en la plataforma Sapiotheca";
				mail.sendEmail(u.getCorreo(), "Certificado "+curso, contenido);
				model.addAttribute("mensaje","Has obtenido una puntuación de "+puntuacion+"/5");
				model.addAttribute("mensaje2", "¡Enhorabuena por completar el curso!");
			}
			else {
				model.addAttribute("mensaje","Has obtenido una puntuación de "+puntuacion+"/5");
				model.addAttribute("mensaje2", "Sigue intentándolo para obtener tu certificado");
			}
		}
		
		
		
		return "Examenes/examenCompletado";
	}
	
	@GetMapping("/{curso}/crearexamen")
	public String crearExamen(Model model, @PathVariable String curso){
		
		model.addAttribute("curso", curso);
		
		return "Examenes/crearExamen";			
	}
	
	@PostMapping("/{curso}/examencreado")
	public String creadoExamen(Model model,  @PathVariable String curso, @RequestParam String resp1, @RequestParam String resp2, @RequestParam String resp3,
			@RequestParam String resp4, @RequestParam String resp5, HttpSession session,
			@RequestParam String preg1, @RequestParam String preg2, @RequestParam String preg3,
			@RequestParam String preg4, @RequestParam String preg5){
		

		
		//Base de datos
		Curso c = cursoRepo.findById(Long.parseLong(curso));
		
		if(c != null) {
			Examen m = new Examen(c);	//Crear y guardar nuevo examen
			m.addPregunta(new Pregunta(preg1, resp1));
			m.addPregunta(new Pregunta(preg2, resp2));
			m.addPregunta(new Pregunta(preg3, resp3));
			m.addPregunta(new Pregunta(preg4, resp4));
			m.addPregunta(new Pregunta(preg5, resp5));
			m.setCurso(c);	//Lo asocia con el curso concreto 
			
			Optional<Examen> examenActual = examRepo.findByCurso(c);
			
			if(examenActual.isPresent()) {
				examRepo.delete(examenActual.get());
			}
			examRepo.save(m);
		}
		
		model.addAttribute("curso", curso);
		model.addAttribute("mensaje", "Se ha creado el exámen con éxito");
		return "Examenes/examenCreado";
	}
	
	@GetMapping("/sesion_cerrada")
	public String sesionCerrada(Model model, HttpSession sesion) {
		
		Usuario u = (Usuario)sesion.getAttribute("user");
		
		if(u != null) {
			sesion.setAttribute("user", null);
		}
		
		return "PaginaDeInicio/sesion_cerrada";
	}
}
