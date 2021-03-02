package com.example.demo.Controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Foros;
import com.example.demo.Model.Mensaje;
import com.example.demo.Model.Usuario;

import java.util.ArrayList;
import java.util.List;



@Controller
public class IndexController {
	
	private List<Foros> foros = new ArrayList<>();
	
	public IndexController () {		
		foros.add(new Foros("DUDA", "BLABLABLA"));		
	}
	
	@GetMapping("/foros")
	public String MostrarForos (Model model) {
		
		foros.add(new Foros("PREGUNTA", "BLABLABLA"));		
		model.addAttribute("foros", foros);
		
		return "Foros";
	}
	
	@PostMapping("/foros/nuevoforo/creado")
	public String NuevoForo(Model model, @RequestParam String asunto, @RequestParam String mensaje) {

		//foros.add(new Foros(asunto, mensaje));
		
		return "forocreado";
	}
	
	
	@GetMapping("/foros/{IDForo}")
	public String VerForo (Model model, @PathVariable int IDForo) {
		
		Foros foro = foros.get(IDForo-1);
		ArrayList m = foro.getMensajes();
		
		
		Usuario usuario = new Usuario();
		usuario.setNombre("soyunusuario");
		m.add(new Mensaje(usuario, "hola"));
		
		model.addAttribute("info", foro);
		model.addAttribute("mensaje", m);
		
		return "Foro";
	}
	
	
	@GetMapping("/foros/nuevoforo")
	public String CrearForo (Model model) {
		
		return "CrearForo";
	}
	
	
	@GetMapping("/")
	public String indexMain(Model model) {
		return "index.html";
	}
	
	//Llamada cuando pulsamos el botón de Login, aparecerá el formulario para logearse.
	@GetMapping("/login")
	public String loginMain(Model model) {
		return "formulario_login";
	}
	
	//Llamada cuando pulsemos el botón de Registrarse, aparecerá el formulario de New User
	@GetMapping("/newuser")
	public String newuserMain(Model model) {
		return "formulario_newuser";
	}
	
	//Se llama al método cuando se pulsa el botón "Iniciar Sesión" o "Registrarse", y se muestra la plantilla de bienvenido.
	@PostMapping("/bienvenido")
	public String bienvenido(Model model, @RequestParam String correo, @RequestParam String contrasena) {
		model.addAttribute("correo", correo);
		model.addAttribute("contraseña", contrasena);
		
		return "bienvenido";
	}
	
	/*@GetMapping("/iniciada")
	public String sesionIniciadaMain(Model model, @RequestParam String nombreUsuario) {		
		
		model.addAttribute("name", nombreUsuario);
		
		return "iniciada";
	}*/
	
	@GetMapping("/anuncios")
	public String anuncios(Model model) {
		
		
		return "Anuncios";
	}	
	
	@GetMapping("/anuncios/{idAnuncio}")
	public String anuncio(Model model, @PathVariable String idAnuncio) {
		
		model.addAttribute("infoProfesor", idAnuncio);
		model.addAttribute("nombreProfesor", "Nombre del profesor");
		
		return "Anuncio";
	}
}
