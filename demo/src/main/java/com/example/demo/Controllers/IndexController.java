package com.example.demo.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialException;
import javax.swing.ImageIcon;

import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Model.Anuncio;
import com.example.demo.Model.Curso;
import com.example.demo.Model.Foros;
import com.example.demo.Model.Mensaje;
import com.example.demo.Model.Usuario;
import com.example.demo.Repository.AnuncioRepository;
import com.example.demo.Repository.CursoRepository;
import com.example.demo.Repository.ForosRepository;
import com.example.demo.Repository.UsuarioRepository;
import com.example.demo.services.FilterService;
import com.example.demo.services.ImageService;

import java.util.ArrayList;
import java.util.List;

import java.io.ByteArrayOutputStream;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;



@Controller
public class IndexController {
	
	private List<Foros> foros = new ArrayList<>();
	private List<Curso> cursos = new ArrayList<Curso>();
	private List<Anuncio> anuncios = new ArrayList<Anuncio>();
	private List<Mensaje> m;
	public static Usuario usuario = new Usuario();
	public static String bphoto;
	
	
	
	@Autowired 
	private UsuarioRepository userRep;
	
	@Autowired 
	private AnuncioRepository repositorioAnuncios;
	

	@Autowired 
	private ForosRepository repositorioForos;
	
	@Autowired 
	private CursoRepository repositorioCurso;
	
	@Autowired
	private ImageService imageServ;
	
	@Autowired
	private FilterService filter;
	
	
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
	public String profesorAgregado(Model model, @RequestParam String correo, @RequestParam String contraseña_1, @RequestParam String apellido1,
			@RequestParam String apellido2, @RequestParam String nombreUsuario, HttpSession sesion, @RequestParam MultipartFile image) throws IOException, SerialException, SQLException {
			
		model.addAttribute("correo", correo);
		
		Optional<Usuario> u = userRep.findByCorreo(correo);
		if(u.isPresent()) {
			return "volver_a_registro";
		}else {		
			
			Usuario profesor = new Usuario(nombreUsuario, apellido1, apellido2, contraseña_1, 0, 1, correo, 0, null);
			
			//Comprobar que no haya nadie en la base de datos con ese correo
			//*****************
					
			byte[] bytes;
			
			if (image != null) {
				try {
					
					String nombreFoto = image.getOriginalFilename();
					long tamañoFoto = image.getSize();
					
					bytes = image.getBytes();
					
					String formatName = nombreFoto.substring(nombreFoto.lastIndexOf(".") + 1);	
					bytes = imageServ.resize(bytes, 200, 200, formatName);
					
					Blob imagen = new javax.sql.rowset.serial.SerialBlob(bytes);
					usuario.setFotoPerfil(imagen);
					
					bphoto = java.util.Base64.getEncoder().encodeToString(bytes);
					
					model.addAttribute("fotoperfil", bphoto);
					
					profesor.setFotoPerfil(imagen);
				}
				catch (Exception exc){
					return "Fallo al establecer la imagen de perfil";
				}
			}
			
			userRep.save(profesor);
				
			sesion.setAttribute("user", profesor);
		}
		
		return "ProfesorAgregadoConfirmacion";
	}

	
	


	//************ FOROS ************//
	
	
	@GetMapping("/foros")
	public String MostrarForos (Model model) {
		
		if (repositorioForos.findAll() != null) {
			model.addAttribute("foro",  repositorioForos.findAll());
		}
		
		
		return "Foros";
	}
	
	
	@PostMapping("/foros/nuevoforo/creado")
	public String NuevoForo(Model model, @RequestParam String asunto, @RequestParam String mensaje) {
		
		Foros foroNuevo = new Foros(asunto, mensaje, null);
		
		repositorioForos.save(foroNuevo);

		return "forocreado";
	}
	
	@GetMapping("/foros/{IDForo}")
	public String VerForo(Model model, @PathVariable int IDForo) {
		
		
		Optional<Foros> foro = repositorioForos.findById(IDForo);
		 if (foro.isPresent()) {
				model.addAttribute("infoForo",foro.get());
		 }
		
		return "Foro";
	}
	
	@PostMapping("/foros/{IDForo}/respuesta")
	public String VerForo (Model model, @PathVariable int IDForo, @RequestParam String respuesta, HttpSession session) {
		
		
		Optional<Foros> foro = repositorioForos.findById(IDForo);
		 if (foro.isPresent()) {
			Foros f = foro.get();
			Usuario user = (Usuario) session.getAttribute("user");
			f.AñadirMensaje(new Mensaje(user, filter.filtrarLenguaje(respuesta)));
			repositorioForos.save(f);
			
			model.addAttribute("infoForo",foro.get());
		 }
		
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
		model.addAttribute("atributo", true);
		return "Iniciar_Sesion";
	}
	
	//Llamada cuando pulsemos el botón de Registrarse, aparecerá el formulario de New User
	@GetMapping("/newuser")
	public String newuserMain(Model model) {
		model.addAttribute("atributo", true);
		return "Registro_NuevoUsuario";
	}
	
	
	//************ BIENVENIDA Y PAGINA PRINCIPAL ************//
	
		//Se llama al método cuando se pulsa el botón "Iniciar Sesión" o "Registrarse", y se muestra la plantilla de bienvenido.
		@PostMapping("/bienvenido")
		public String bienvenido(Model model, @RequestParam String correo, @RequestParam String contraseña_1, @RequestParam MultipartFile image,
				@RequestParam String nombreUsuario, @RequestParam String primerApellido, @RequestParam String apellido2,
				@RequestParam("tipoUsuario") String tipoUsuario, @RequestParam("metodoPago") String metodoPago, HttpSession sesion) {
			
				
			model.addAttribute("correo", correo);
			
			Optional<Usuario> u = userRep.findByCorreo(correo);
			if(u.isPresent()) {
				return "volver_a_registro";
			}else {		
				int tipoU, metodoP;
				
				if(tipoUsuario.equals("Usuario estándar")) tipoU = 0;
				else tipoU = 1;
				
				if(metodoPago.equals("Tarjeta de crédito")) metodoP = 0;
				else metodoP = 1;
				
				Usuario registrado = new Usuario(nombreUsuario, primerApellido, apellido2, 
						contraseña_1, 0, tipoU, correo, metodoP, null);
				
				//Comprobar que no haya nadie en la base de datos con ese correo
				//*****************
						
				byte[] bytes;
				
				if (!image.isEmpty()) {
					try {
						// Por si se quiere guardar tambien el nombre y el tamaño de la imagen
						String nombreFoto = image.getOriginalFilename();
						long tamañoFoto = image.getSize();
						
						bytes = image.getBytes();
						
						String formatName = nombreFoto.substring(nombreFoto.lastIndexOf(".") + 1);	
						bytes = imageServ.resize(bytes, 200, 200, formatName);
						
						Blob imagen = new javax.sql.rowset.serial.SerialBlob(bytes);
						usuario.setFotoPerfil(imagen);
						
						bphoto = java.util.Base64.getEncoder().encodeToString(bytes);
						
						model.addAttribute("fotoperfil", bphoto);
						
						registrado.setFotoPerfil(imagen);
					}
					catch (Exception exc){
						return "Fallo al establecer la imagen de perfil";
					}
				}
				
				userRep.save(registrado);
					
				sesion.setAttribute("user", registrado);
				
				return "bienvenido";
			}
		}
	
	@PostMapping("/bienvenidoI")
	public String bienvenidoInicio(Model model, @RequestParam String correo, @RequestParam String contrasena, HttpSession sesion) {
		
		model.addAttribute("correo", correo);
		
		Optional<Usuario> u = userRep.findByCorreo(correo);
		if(u.isPresent()) {
			if(contrasena.equals(u.get().getContraseña())) {
				sesion.setAttribute("user", u.get());
				return "bienvenidoI";
			}else {
				return "volver_a_login";
			}
		}else {
			return "no_registrado";
		}
	}
	
	//************ ANUNCIOS ************//
	
		@GetMapping("/anuncios")
		public String anuncios(Model model) {
			
		
			if (repositorioAnuncios.findAll() != null) {
				model.addAttribute("anuncios",  repositorioAnuncios.findAll());
			}

			return "Anuncios";
		}	
		
		@GetMapping("/crearAnuncio")
		public String crearAnuncio(Model model) {
			
			return "formulario_crear_anuncio";
			
		}
		
		
		@PostMapping("/anuncioCreado")
		public String anuncioCreado(Model model, @RequestParam String materia, @RequestParam String curso, 
				@RequestParam String horario, @RequestParam String precio, @RequestParam String contenido, HttpSession session) {
			
			Usuario user = (Usuario)session.getAttribute("user");
			Anuncio anuncio = new Anuncio(user, materia, contenido, horario, precio, curso);
			repositorioAnuncios.save(anuncio);
			
			
			return "anuncio_creado";
		}
		
		@GetMapping("/anuncios/{IDAnuncio}")
		public String anuncio(Model model, @PathVariable int IDAnuncio) {
			
			
			Optional<Anuncio> anuncio = repositorioAnuncios.findById(IDAnuncio);
			
			 if (anuncio.isPresent()) {
					model.addAttribute("infoAnuncio",anuncio.get());
			 }
			
			return "Anuncio";
		}
		
		@GetMapping("/eliminarAnuncio/{index}")
		public String eliminarAnuncio(Model model, @PathVariable int index) {
			
			//anuncios.remove(index-1);
			
			repositorioAnuncios.deleteById(index);

			return "anuncio_eliminado";
		}
		
		
		//************ CURSOS ************//
		
	@GetMapping("/cursosDisponibles")
	public String cursosDisponibles(Model model, HttpSession sesion) {
		
		
		Usuario usuario = (Usuario) sesion.getAttribute("user");		
		
		
		if (userRep.findById(usuario.getId()).isPresent()) {
			model.addAttribute("puedeGestionarCursos", true);
		} else {
			model.addAttribute("puedeGestionarCursos", false);
		}
		
		List<Curso> cursos = repositorioCurso.findAll();
		
		
		model.addAttribute("cursos", cursos);
		
		return "Cursos";
	}
	
	
	@GetMapping("/eliminarCurso/{index}")
	public String eliminarCurso(Model model, @PathVariable int index) {
		
		Curso cursoEliminado = repositorioCurso.findById(index);
		repositorioCurso.delete(cursoEliminado);
		
		
		return "CursoEliminado";
	}
	
	@GetMapping("/curso/{index}")
	public String verCurso(Model model, @PathVariable int index) throws SQLException {	
		
		Curso curso = repositorioCurso.findById(index);
		ArrayList<String> listaImagenes = new ArrayList<String>();
		
		if (curso != null) {
			List<Blob> listaArchivosMostrar = curso.getArchivos();
			for(int i = 0; i<listaArchivosMostrar.size(); i++) {
				byte[] bdata = listaArchivosMostrar.get(i).getBytes(1, (int) listaArchivosMostrar.get(i).length());
				String s = java.util.Base64.getEncoder().encodeToString(bdata);
				listaImagenes.add(s);
			}
			
			model.addAttribute("archivos", listaImagenes);
			model.addAttribute("index", index);
		}
		
		
		
		return "informacion_curso";
	}
	
	
	@GetMapping("/crearCurso")
	public String crearCurso(Model model) {
	
		return "Crear_Curso";
	}
	
	@PostMapping("/{id}/materialSubido")
	public String materialAñadido (Model model, @PathVariable int id, @RequestParam MultipartFile archivo){
		
		Curso curso = repositorioCurso.findById(id);
		ArrayList<Blob> listaAntigua = curso.getArchivos();
			
		byte[] bytes;		
		if (!archivo.isEmpty()) {
			try {
				bytes = archivo.getBytes();
				Blob imagen = new javax.sql.rowset.serial.SerialBlob(bytes);
				listaAntigua.add(imagen);
				curso.setArchivo(listaAntigua);								
			}
			catch (Exception exc){
				return "Fallo al establecer la imagen de perfil";
			}			
			repositorioCurso.save(curso);
		}	
		return "material_Añadido";
	}
	
	@GetMapping("/{id}/añadirMaterial")
	public String subirMaterial (Model model, @PathVariable int id){
		model.addAttribute("id", id);
		return "subir_Material";
	}
	
	
	
	@PostMapping("/crearCursoConfirmacion")
	public String crearCursoConfirmacion(Model model, @RequestParam String titulo, @RequestParam String descripcion, HttpSession sesion) {
	
		
		/*usuario.AñadirCurso(titulo, descripcion);*/
		
		Usuario usuario = (Usuario) sesion.getAttribute("user");
		
		Curso nuevoCurso = new Curso(titulo, descripcion, usuario);
		repositorioCurso.save(nuevoCurso);
		
		return "Curso_Creado_Confirmacion";
	}
	
	@GetMapping("/cursosDisponibles/Actualizado")
	public String actualizarNuevoCurso(Model model) {	
		
		return "Nuevo_Curso";
	}
	
	@GetMapping("/paginaprincipal")
	public String paginaPrincipal(Model model, HttpSession sesion) {	
		
		
		
		Usuario u = (Usuario) sesion.getAttribute("user");
		if(u == null) {
			
			Optional<Usuario> user = userRep.findByCorreo("------------");
			if(user.isPresent()){
			  sesion.setAttribute("user", user.get());
			}
			else{
			  u = new Usuario("------------", "------------", "------------", "------------", 0, 0, "------------", 0, null);;
			  sesion.setAttribute("user", u);
			  userRep.save(u);
			}
		} 

		return "paginaprincipal";
	}
	

}
