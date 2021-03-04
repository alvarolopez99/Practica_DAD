package com.example.demo.Controllers;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Model.Usuario;
import com.example.demo.Repository.UsuarioRepository;
import com.mysql.cj.jdbc.Blob;

@Controller
public class UserController {
	
	@Autowired
	UsuarioRepository userRepo;
	
	@GetMapping("/profile")
	public String editUser(Model model, HttpSession session) {
		
		//Leer usuario actual del httpsession
		/*
		Usuario user = (Usuario)sesion.getAttribute("user");
		*/
		
		//Inicializacion de usuario provisional
		Usuario user = new Usuario("Pablo", "Bayona", "González", "contraseña123", 0, 0, "correo@correo.es", 0, null);
		
		
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
		
		return "editarperfil";
	}
	
	@GetMapping("/deleteUser")
	public String deleteUser(Model model, HttpSession session) {
		
		//Leer usuario actual del httpsession
		/*
		Usuario user = (Usuario)session.getAttribute("user");
		userRepo.remove(user);
		session.setAttribute("user", null);
		
		*/
		
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
}
