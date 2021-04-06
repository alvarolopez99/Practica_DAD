package es.urjc.dad.web.Controller;

import org.springframework.web.bind.annotation.PostMapping;


public class RestController {

	@PostMapping(value = "/FiltrarLenguaje")
	public String FiltrarLenguaje() {
		
		String MensajeFiltrado = "";
		//Logica del filtrado de mensajes
		
		return MensajeFiltrado;
		
	}
	
}
