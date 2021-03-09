package com.example.demo.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Chat;
import com.example.demo.Model.Foros;
import com.example.demo.Model.Mensaje;
import com.example.demo.Model.Usuario;
import com.example.demo.Repository.ChatRepository;
import com.example.demo.Repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ChatController {

	@Autowired 
	private UsuarioRepository repositorio;
	
	@Autowired
	private ChatRepository chatRepo;
	
	
	@GetMapping("/chat/{profesor}/send")	//Pagina del chat cuando se envia un mensaje
	public String envioMensaje(Model model, @RequestParam String usermsg, @PathVariable String profesor, HttpSession sesion) {

		
		//Añadir la carga de mensajes mediante lista
		
		Optional<Usuario> p = repositorio.findById(Long.parseLong(profesor));
		if(p.isPresent()) {
			Usuario prof = p.get();
			Usuario user = (Usuario)sesion.getAttribute("user");
			model.addAttribute("user", user.getNombre());
			Optional<Chat> chatO = chatRepo.findByProfesorAndAlumno(prof, user);
			if(chatO.isPresent()) {
				Chat chat = chatO.get();
				if(!usermsg.equals("")) {
					
					chat.AñadirMensaje(new Mensaje(user, usermsg));	//Se añade el nuevo mensaje creado
					model.addAttribute("mensajes", chat.getMensajes());
					chatRepo.save(chat);
							
				}
				model.addAttribute("target", chat.getProfesor());
				
			}
			else {
				model.addAttribute("mensajes", null);
			}
		}

		return "chat";
	}
	
	@GetMapping("/chat/{profesor}")	//Pagina de inicio del chat
	public String abrirChat(Model model, @PathVariable String profesor, HttpSession sesion) {
		
		/*	Para recuperar el usuario actual */
		Usuario user = (Usuario)sesion.getAttribute("user");
		model.addAttribute("user", user.getNombre());

		
		/* Para la lista de mensajes */
		 
		 Optional<Usuario> profUser = repositorio.findById(Long.parseLong(profesor));
		 
		 if(profUser.isPresent()) {	//Busca al profesor del chat y si existe
			 
			 Usuario prof = profUser.get();
			 model.addAttribute("target", prof);
			 
			 Optional<Chat> currentChat = chatRepo.findByProfesorAndAlumno(prof, user);
			 
			 Chat chat;
			 if(currentChat.isPresent()) {	//El chat ya existe
				 
				 chat = currentChat.get();
				 List<Mensaje> mensajes = chat.getMensajes();
				 
			 }
			 else {	// Se crea el chat porque no existe
				 
				 chat = new Chat(prof, user);
				 chatRepo.save(chat);
			 }
			 
			 model.addAttribute("mensajes", chat.getMensajes());
		 }
		

		return "chat";
	}
}
