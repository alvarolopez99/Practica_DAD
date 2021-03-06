package com.example.demo.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.net.MalformedURLException;
import java.sql.Blob;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Uso_BD;
import com.example.demo.Model.Anuncio;
import com.example.demo.Model.Curso;
import com.example.demo.Model.Foros;
import com.example.demo.Model.Material;
import com.example.demo.Model.Mensaje;
import com.example.demo.Model.Usuario;
import com.example.demo.Repository.UsuarioRepository;
import com.example.demo.services.Service;

import java.util.ArrayList;
import java.util.List;



@Controller
public class IndexController {
	
	private List<Foros> foros = new ArrayList<>();
	private List<Curso> cursos = new ArrayList<Curso>();
	private List<Anuncio> anuncios = new ArrayList<Anuncio>();
	private ArrayList m;
	public static Usuario usuario = new Usuario();
	public static String bphoto;
	public Uso_BD uso_bd = new Uso_BD();
	//public Service service = new Service();
	
	@Autowired 
	private UsuarioRepository userRep;
	
	public IndexController () {		
		
		foros.add(new Foros("DUDA", "BLABLABLA", null));	
	}
	
	
	//************ PAGINA INICIAL ************//
	
	@GetMapping("/")
	public String indexMain(Model model) {
		return "PaginaInicio";
	}
	
	
	@GetMapping("/administrador")
	public String administrador(Model model) {
		return "Administrador";
	}
	
	@PostMapping("/profesorAgregado")
	public String profesorAgregado(Model model, @RequestParam String correo, @RequestParam String contraseña) {

		model.addAttribute("correo", correo);
		
		return "ProfesorAgregadoConfirmacion";
	}
	
	
	//************ FOROS ************//
	
	
	@GetMapping("/foros")
	public String MostrarForos (Model model) {
		
		//foros.add(new Foros("PREGUNTA", "BLABLABLA"));		
		model.addAttribute("foros", foros);
		
		return "Foros";
	}
	
	
	@PostMapping("/foros/nuevoforo/creado")
	public String NuevoForo(Model model, @RequestParam String asunto, @RequestParam String mensaje) {

		foros.add(new Foros(asunto, mensaje, null));
		
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
	public String bienvenido(Model model, @RequestParam String correo, @RequestParam String contraseña_1, @RequestParam MultipartFile image,
			@RequestParam String nombreUsuario) {
		
		model.addAttribute("correo", correo);
		model.addAttribute("contraseña", contraseña_1);
		
		
		
		
		byte[] bytes;
		
		if (image != null) {
			try {
				// Por si se quiere guardar tambien el nombre y el tamaño de la imagen
				String nombreFoto = image.getOriginalFilename();
				long tamañoFoto = image.getSize();
				
				bytes = image.getBytes();
				Blob imagen = new javax.sql.rowset.serial.SerialBlob(bytes);
				usuario.setFotoPerfil(imagen);
				
				bphoto = java.util.Base64.getEncoder().encodeToString(bytes);
				
				model.addAttribute("fotoperfil", bphoto);
				
				userRep.save(new Usuario(nombreUsuario, "lopez", "sierra", contraseña_1, 0, 0, correo, 0, imagen));
			}
			catch (Exception exc){
				return "Fallo al establecer la imagen de perfil";
			}
		}
		
		
			
		return "bienvenido";
	}
	
	@PostMapping("/bienvenidoI")
	public String bienvenidoInicio(Model model, @RequestParam String correo, @RequestParam String contrasena) {
		
		model.addAttribute("correo", correo);
		
		return "bienvenidoI";
	}
	
	/*@GetMapping("/iniciada")
	public String sesionIniciadaMain(Model model, @RequestParam String nombreUsuario) {		
		
		model.addAttribute("name", nombreUsuario);
		
		return "iniciada";
	}*/
	
	
	//************ ANUNCIOS ************//
	
	@GetMapping("/anuncios")
	public String anuncios(Model model) {
		
		model.addAttribute("anuncios", anuncios);
		
		return "Anuncios";
	}	
	
	@GetMapping("/crearAnuncio")
	public String crearAnuncio(Model model) {
		
		return "formulario_crear_anuncio";
	}
	
	@PostMapping("/anuncioCreado")
	public String anuncioCreado(Model model, @RequestParam String materia, @RequestParam String curso, 
			@RequestParam String horario, @RequestParam String precio, @RequestParam String contenido) {
		
		usuario.setNombre("Alvaro");
		anuncios.add(new Anuncio (usuario, materia, contenido, horario, precio, curso) ); //Falta pasar como primer parámetro el profesor que crea el anuncio
		
		//service.CrearAnuncio();
		
		return "anuncio_creado";
	}
	
	@GetMapping("/anuncios/{IDAnuncio}")
	public String anuncio(Model model, @PathVariable int IDAnuncio) {
		
		//model.addAttribute("infoProfesor", idAnuncio);
		//model.addAttribute("nombreProfesor", "Nombre del profesor");

		
		Anuncio anuncio = anuncios.get(IDAnuncio-1);
		
		
		
		model.addAttribute("infoAnuncio", anuncio);
		Usuario profesor = anuncio.getProfesor();
		model.addAttribute("profesor", profesor);
		
		
		
		
		return "Anuncio";
	}
	
	@GetMapping("/eliminarAnuncio/{index}")
	public String eliminarAnuncio(Model model, @PathVariable int index) {
		
		anuncios.remove(index-1);
		
		return "anuncio_eliminado";
	}
	
	
	//************ CURSOS ************//
	
	@GetMapping("/cursosDisponibles")
	public String cursosDisponibles(Model model) {
		
		/*
		List <String> imagenes_Cursos = Arrays.asList("https://i0.wp.com/mathsteachercircles.org.au/wp-content/uploads/2020/10/cropped-MTC_Icon_RGB.png?fit=190%2C190&ssl=1","https://pbs.twimg.com/profile_images/1110160859689615361/V8CE--1C.png");
		
		for (int i=0; i<imagenes_Cursos.size();i++) {
			Curso c = new Curso();
			c.setImagen(imagenes_Cursos.get(i));
			cursos.add(c);
		}
		*/
		//imagenes_Cursos.add("https://i0.wp.com/mathsteachercircles.org.au/wp-content/uploads/2020/10/cropped-MTC_Icon_RGB.png?fit=190%2C190&ssl=1");
		//imagenes_Cursos.add("https://pbs.twimg.com/profile_images/1110160859689615361/V8CE--1C.png");
		
		model.addAttribute("cursos", cursos);
		
		return "Cursos";
	}
	
	
	@GetMapping("/eliminarCurso/{index}")
	public String eliminarCurso(Model model, @PathVariable int index) {
		
		cursos.remove(index-1);
		
		return "CursoEliminado";
	}
	
	@GetMapping("/curso/{index}")
	public String verCurso(Model model, @PathVariable int index) {	
		
		model.addAttribute("index", index);
		
		return "informacion_curso";
	}
	
	/*
	@GetMapping("/cursosDisponibles/nuevoCurso")
	public String nuevoCurso(Model model) {
				
		//List <String> imagenes_Cursos = Arrays.asList("https://i0.wp.com/mathsteachercircles.org.au/wp-content/uploads/2020/10/cropped-MTC_Icon_RGB.png?fit=190%2C190&ssl=1","https://pbs.twimg.com/profile_images/1110160859689615361/V8CE--1C.png", "https://upload.wikimedia.org/wikipedia/en/c/cd/March_for_Science.png");
		
		model.addAttribute("cursos", imagenes_Cursos);
		
		return "Nuevo_Curso";
	}
	*/
	
	@GetMapping("/crearCurso")
	public String crearCurso(Model model) {
	
		return "Crear_Curso";
	}
	
	@PostMapping("/crearCursoConfirmacion")
	public String crearCursoConfirmacion(Model model, @RequestParam String titulo, @RequestParam String descripcion) {
	
		cursos.add(new Curso(titulo, descripcion, null));
		
		return "Curso_Creado_Confirmacion";
	}
	
	@GetMapping("/cursosDisponibles/Actualizado")
	public String actualizarNuevoCurso(Model model) {	
		
		return "Nuevo_Curso";
	}
	
	@GetMapping("/paginaprincipal")
	public String paginaPrincipal(Model model) {	
		
		Optional<Usuario> u = userRep.findByNombre("alvaro");
		model.addAttribute("usuario", u);
		
		return "paginaprincipal";
	}
	

}
