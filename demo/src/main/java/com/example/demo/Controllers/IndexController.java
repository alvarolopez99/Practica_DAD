package com.example.demo.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Curso;
import com.example.demo.Model.Foros;
import com.example.demo.Model.Material;
import com.example.demo.Model.Mensaje;
import com.example.demo.Model.Usuario;
import com.example.demo.Repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;



@Controller
public class IndexController {
	
	private List<Foros> foros = new ArrayList<>();
	private ArrayList m;
	private Usuario usuario = new Usuario();
	
	@Autowired 
	private UsuarioRepository repositorio;
	
	public IndexController () {		
		foros.add(new Foros("DUDA", "BLABLABLA"));	
	}
	
	
	//************ PAGINA INCIAL ************//
	
	@GetMapping("/")
	public String indexMain(Model model) {
		return "PaginaInicio";
	}
	
	
	//************ FOROS ************//
	
	
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
	
	@PostMapping("/foros/{IDForo}/respuesta")
	public String VerForo (Model model, @PathVariable int IDForo, @RequestParam String respuesta) {
		
		Foros foro = foros.get(IDForo-1);
		m = foro.getMensajes();
		usuario.setNombre("Soy un usuario");
		m.add(new Mensaje(usuario, respuesta));
		model.addAttribute("info", foro);
		model.addAttribute("mensaje", m);
		model.addAttribute("IDForo", (IDForo));
		
		return "Foro";
	}
	
	@GetMapping("/foros/{IDForo}")
	public String VerForo(Model model, @PathVariable int IDForo) {
		
		Foros foro = foros.get(IDForo-1);
		m = foro.getMensajes();
		usuario.setNombre("Soy un usuario");
		m.add(new Mensaje(usuario, "Y este es mi mensaje estático"));
		model.addAttribute("info", foro);
		model.addAttribute("mensaje", m);
		model.addAttribute("IDForo", (IDForo));
	
		return "Foro";
	}
	
	@GetMapping("/foros/nuevoforo")
	public String CrearForo (Model model) {
		
		return "CrearForo";
	}
	
	
	//************ LOGIN Y REGISTRO ************//
	
	//Llamada cuando pulsamos el botón de Login, aparecerá el formulario para logearse.
	@GetMapping("/login")
	public String loginMain(Model model) {
		return "Iniciar_Sesion";
	}
	
	/*	@PostMapping("/checkLogin")
	public String comprobarLogin(Model model, @RequestParam String correo, @RequestParam String contrasena) {		
	
		String url = "Error_Login";
		
		Optional<Usuario> usuario = repositorio.findByNombre(nombre);
		
		if(usuario.isPresent()) {
			
			if (contrasena == usuario.getContraseña()) {
				url = "Sesion_Iniciada_Template";
			} else {
				String error = "Contraseña errónea";
				model.addAttribute("mensajeError", error);
			}
			
		} else {
			String error = "Nombre de usuario erróneo";
			model.addAttribute("mensajeError", error);
		}
		
		
		return url;
	}*/
	
	/*
	@GetMapping("/descargarMaterial")
	public ResponseEntity<Object> descargarMaterial(Model model) throws MalformedURLException {
		
		Path pathMaterial = MATERIAL_FOLDER.resolve("material.pdf");
		Resource material = new UrlResource(pathMaterial.toUri());
		
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "file/pdf").body(material);

	}
	*/
	
	//Llamada cuando pulsemos el botón de Registrarse, aparecerá el formulario de New User
	@GetMapping("/newuser")
	public String newuserMain(Model model) {
		return "Registro_NuevoUsuario";
	}
	
	
	//************ BIENVENIDA Y PAGINA PRINCIPAL ************//
	
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
	
	
	//************ ANUNCIOS ************//
	
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
	
	
	//************ CURSOS ************//
	
	@GetMapping("/cursosDisponibles")
	public String cursosDisponibles(Model model) {
		
		List<Curso> cursos = new ArrayList<Curso>();
		
		List <String> imagenes_Cursos = Arrays.asList("https://i0.wp.com/mathsteachercircles.org.au/wp-content/uploads/2020/10/cropped-MTC_Icon_RGB.png?fit=190%2C190&ssl=1","https://pbs.twimg.com/profile_images/1110160859689615361/V8CE--1C.png");
		
		//imagenes_Cursos.add("https://i0.wp.com/mathsteachercircles.org.au/wp-content/uploads/2020/10/cropped-MTC_Icon_RGB.png?fit=190%2C190&ssl=1");
		//imagenes_Cursos.add("https://pbs.twimg.com/profile_images/1110160859689615361/V8CE--1C.png");
		
		model.addAttribute("cursos", imagenes_Cursos);
		
		return "Cursos";
	}
	
	@GetMapping("/cursosDisponibles/nuevoCurso")
	public String nuevoCurso(Model model) {
		
		List<Curso> cursos = new ArrayList<Curso>();
			
		List <String> imagenes_Cursos = Arrays.asList("https://i0.wp.com/mathsteachercircles.org.au/wp-content/uploads/2020/10/cropped-MTC_Icon_RGB.png?fit=190%2C190&ssl=1","https://pbs.twimg.com/profile_images/1110160859689615361/V8CE--1C.png", "https://upload.wikimedia.org/wikipedia/en/c/cd/March_for_Science.png");
		
		model.addAttribute("cursos", imagenes_Cursos);
		
		return "Nuevo_Curso";
	}
	
	@GetMapping("/cursosDisponibles/Actualizado")
	public String actualizarNuevoCurso(Model model) {
		
		
		
		return "Nuevo_Curso";
	}
	

}
