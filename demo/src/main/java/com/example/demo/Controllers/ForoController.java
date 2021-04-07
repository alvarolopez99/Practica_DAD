package com.example.demo.Controllers;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Foros;
import com.example.demo.Model.Mensaje;
import com.example.demo.Model.Usuario;
import com.example.demo.Repository.ForosRepository;
import com.example.demo.Repository.UsuarioRepository;
import com.example.demo.services.FilterService;

@Controller
public class ForoController {
	
	@Autowired
	private FilterService filter;
	
	@Autowired 
	private ForosRepository repositorioForos;
	@Autowired
	private UsuarioRepository userRep;
	
	
	@GetMapping("/foros")
	public String MostrarForos (Model model, HttpServletRequest request) {
		
		Optional<Usuario> u = userRep.findById((long) 1);
		
		Principal p = request.getUserPrincipal();
		
		boolean esUser = request.isUserInRole("ADMIN");
			
		model.addAttribute("user", esUser);	
		model.addAttribute("rol", u.get().getRoles());

		
		if (repositorioForos.findAll() != null) {
			model.addAttribute("foro",  repositorioForos.findAll());
		}		
		
		return "Foros/Foros";
	}
	
	
	@PostMapping("/foros/nuevoforo/creado")
	public String NuevoForo(Model model, @RequestParam String asunto, @RequestParam String mensaje,
			HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		Foros foroNuevo = new Foros(asunto, mensaje, null);
		
		repositorioForos.save(foroNuevo);

		return "Foros/forocreado";
	}
	
	@GetMapping("/foros/{IDForo}")
	public String VerForo(Model model, @PathVariable int IDForo/*, HttpServletRequest request*/) {
		
		//model.addAttribute("user", request.isUserInRole("usuario_Registrado") || request.isUserInRole("profesor"));
		
		Optional<Foros> foro = repositorioForos.findById(IDForo);
		 if (foro.isPresent()) {
				model.addAttribute("infoForo",foro.get());
		 }
		
		return "Foros/Foro";
	}
	
	@PostMapping("/foros/{IDForo}/respuesta")
	public String VerForo (Model model, @PathVariable int IDForo, @RequestParam String respuesta, HttpSession session/*, HttpServletRequest request*/) {
		
		//model.addAttribute("user", request.isUserInRole("usuario_Registrado") || request.isUserInRole("profesor"));
		
		Optional<Foros> foro = repositorioForos.findById(IDForo);
		 if (foro.isPresent()) {
			Foros f = foro.get();
			Usuario user = (Usuario) session.getAttribute("user");
			f.AñadirMensaje(new Mensaje(user, filter.filtrarLenguaje(respuesta)));
			repositorioForos.save(f);
			
			model.addAttribute("infoForo",foro.get());
		 }
		
		return "Foros/Foro";
	}
	
	
	
	@GetMapping("/foros/nuevoforo")
	public String CrearForo (Model model) {
		
		return "Foros/CrearForo";
	}
	
}
