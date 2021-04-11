package com.example.demo.Controllers;

import javax.servlet.http.HttpServlet;
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

import com.example.demo.Model.Chat;
import com.example.demo.Model.Foros;
import com.example.demo.Model.Mensaje;
import com.example.demo.Model.Usuario;
import com.example.demo.Repository.ChatRepository;
import com.example.demo.Repository.UsuarioRepository;
import com.example.demo.services.FilterService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ChatController {

	@Autowired 
	private UsuarioRepository repositorio;
	
	@Autowired
	private ChatRepository chatRepo;
	
	@Autowired
	private FilterService filter;
	
	@GetMapping("/chatsProfesor")
	public String chatsProfesor(Model model/*, HttpSession session*/, HttpServletRequest request) {
		
		Principal p = request.getUserPrincipal();
		
		Optional<Usuario> profesor = repositorio.findByCorreo(p.getName());
		
		List<Chat> chats = chatRepo.findByProfesor(profesor.get());
		
		model.addAttribute("chats", chats);

		return "Chats/Chats";
	}
	
	@GetMapping("/chatsProfesor/{idChat}")
	public String chatProfesorAlumno(Model model/*, HttpSession session*/, HttpServletRequest request, @PathVariable String idChat) {
		
		Optional<Chat> chat = chatRepo.findById(Long.parseLong(idChat));
		if(chat.isPresent()) {
			Chat c = chat.get();
			
			model.addAttribute("mensajes", c.getMensajes());
			Principal p = request.getUserPrincipal();		
			Optional<Usuario> profesor = repositorio.findByCorreo(p.getName());
			model.addAttribute("user", profesor.get().getNombre());		
			model.addAttribute("target", c.getAlumno());
			model.addAttribute("idChat", idChat);
		}

		return "Chats/chatProfesor";
	}
	
	@PostMapping("/chatsProfesor/{idChat}/send")
	public String chatProfesorAlumno(Model model, HttpSession session, @PathVariable String idChat, @RequestParam String usermsg,
			HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		
		Optional<Chat> chat = chatRepo.findById(Long.parseLong(idChat));
		if(chat.isPresent()) {
			Chat c = chat.get();
			Principal p = request.getUserPrincipal();		
			Optional<Usuario> profesor = repositorio.findByCorreo(p.getName());
			c.AñadirMensaje(new Mensaje(profesor.get(), filter.filtrarLenguaje(usermsg)));
			
			chatRepo.save(c);
			
			model.addAttribute("mensajes", c.getMensajes());
			model.addAttribute("user", profesor.get().getNombre());		
			model.addAttribute("target", c.getAlumno());
			model.addAttribute("idChat", idChat);
		}

		return "Chats/chatProfesor";
	}
	
	@PostMapping("/chat/{profesor}/send")	//Pagina del chat cuando se envia un mensaje
	public String envioMensaje(Model model, @RequestParam String usermsg, @PathVariable String profesor, HttpSession sesion,
			HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		
		//Añadir la carga de mensajes mediante lista
		
		Optional<Usuario> p = repositorio.findById(Long.parseLong(profesor));
		if(p.isPresent()) {
			Usuario prof = p.get();
			Principal principal = request.getUserPrincipal();		
			Optional<Usuario> user = repositorio.findByCorreo(principal.getName());
			model.addAttribute("user", user.get().getNombre());
			Optional<Chat> chatO = chatRepo.findByProfesorAndAlumno(prof, user.get());
			if(chatO.isPresent()) {
				Chat chat = chatO.get();
				if(!usermsg.equals("")) {
					
					chat.AñadirMensaje(new Mensaje(user.get(), filter.filtrarLenguaje(usermsg)));	//Se añade el nuevo mensaje creado
					model.addAttribute("mensajes", chat.getMensajes());
					chatRepo.save(chat);
							
				}
				model.addAttribute("target", chat.getProfesor());
				
			}
			else {
				model.addAttribute("mensajes", null);
			}
		}

		return "Chats/chat";
	}
	
	@GetMapping("/chat/{profesor}")	//Pagina de inicio del chat
	public String abrirChat(Model model, @PathVariable String profesor/*, HttpSession sesion*/, HttpServletRequest request) {
		
		model.addAttribute("prof", request.isUserInRole("PROFESOR"));
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		
		/*	Para recuperar el usuario actual */
		Principal p = request.getUserPrincipal();		
		Optional<Usuario> user = repositorio.findByCorreo(p.getName());
		model.addAttribute("user", user.get().getNombre());

		
		/* Para la lista de mensajes */
		 
		 Optional<Usuario> profUser = repositorio.findById(Long.parseLong(profesor));
		 
		 if(profUser.isPresent()) {	//Busca al profesor del chat y si existe
			 
			 Usuario prof = profUser.get();
			 model.addAttribute("target", prof);
			 
			 Optional<Chat> currentChat = chatRepo.findByProfesorAndAlumno(prof, user.get());
			 
			 Chat chat;
			 if(currentChat.isPresent()) {	//El chat ya existe
				 
				 chat = currentChat.get();
				 List<Mensaje> mensajes = chat.getMensajes();
				 
			 }
			 else {	// Se crea el chat porque no existe
				 
				 chat = new Chat(prof, user.get());
				 chatRepo.save(chat);
			 }
			 
			 model.addAttribute("mensajes", chat.getMensajes());
		 }
		

		return "Chats/chat";
	}
}
