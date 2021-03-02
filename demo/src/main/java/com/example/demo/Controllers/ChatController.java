package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChatController {

	@GetMapping("/chat/{profesor}/send")	//Pagina del chat cuando se envia un mensaje
	public String greeting(Model model, @RequestParam String usermsg, @PathVariable String profesor) {


		model.addAttribute("msg", usermsg);
		model.addAttribute("user", "Pablo");
		model.addAttribute("target", profesor);
		

		return "chat";
	}
	
	@GetMapping("/chat/{profesor}")	//Pagina de inicio del chat
	public String greeting(Model model, @PathVariable String profesor) {

		model.addAttribute("msg", "");
		model.addAttribute("user", "Pablo");
		model.addAttribute("target", profesor);
		

		return "chat";
	}
}
