package com.example.demo.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Chat;
import com.example.demo.Model.Mensaje;
import com.example.demo.Model.Usuario;
import com.example.demo.Repository.ChatRepository;
import com.example.demo.Repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class ChatController {

	@Autowired 
	private UsuarioRepository repositorio;
	
	@Autowired
	private ChatRepository chatRepo;
	
	@GetMapping("/chat/{profesor}/send")	//Pagina del chat cuando se envia un mensaje
	public String greeting(Model model, @RequestParam String usermsg, @PathVariable String profesor, HttpSession sesion) {

		
		//Añadir la carga de mensajes mediante lista
		
		model.addAttribute("msg", usermsg);
		model.addAttribute("user", "Pablo");
		model.addAttribute("target", profesor);
		

		return "chat";
	}
	
	@GetMapping("/chat/{profesor}")	//Pagina de inicio del chat
	public String greeting(Model model, @PathVariable String profesor, HttpSession sesion) {
		
		/*	Para recuperar el usuario actual
		Usuario user = (Usuario)sesion.getAttribute("user");
		model.addAttribute("user", user.getNombre());
		*/
		
		/* Para la lista de mensajes
		 
		 Optional<Usuario> profUser = repositorio.findByNombre(profesor);
		 
		 if(profUser.isPresent()) {
			 
			 Usuario prof = profUser.get();
			 model.addAttribute("target", prof.getNombre() + prof.getPrimerApellido());
			 
			 Optional<Chat> currentChat = chatRepo.findByProfesorAndAlumno(prof.getId(), user.getId());
			 
			 if(currentChat.isPresent()) {	//El chat ya existe
				 
				 Chat chat = currentChat.get();
				 List<Mensaje> mensajes = chat.getMensajes();
				 
				 //Añadir atributo mensajes al modelo
				 
			 }
			 else {	// Se crea el chat porque no existe
				 
				 //Crear chat y almacenar en la base de datos
				 
				 //No se añade nada a la lista de mensajes
			 }
		 }
		 
		 */
		
		//Provisional
		model.addAttribute("msg", "");
		model.addAttribute("user", "Pablo");
		model.addAttribute("target", profesor);
		

		return "chat";
	}
}
