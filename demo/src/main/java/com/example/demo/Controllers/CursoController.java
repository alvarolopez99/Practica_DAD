package com.example.demo.Controllers;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Model.Curso;
import com.example.demo.Model.Usuario;
import com.example.demo.Repository.CursoRepository;
import com.example.demo.Repository.UsuarioRepository;

@Controller
public class CursoController {
	
	@Autowired 
	private CursoRepository repositorioCurso;
	@Autowired 
	private UsuarioRepository userRep;
	
	@GetMapping("/cursosDisponibles")
	public String cursosDisponibles(Model model, HttpSession sesion/*, HttpServletRequest request*/) {
		
		/*
		model.addAttribute("user", request.isUserInRole("usuario_Registrado"));
		model.addAttribute("teacher", request.isUserInRole("profesor"));
		*/
		
		Usuario usuario = (Usuario) sesion.getAttribute("user");		
		
		List<Curso> cursos = repositorioCurso.findAll();	
		
		model.addAttribute("cursos", cursos);
		
		return "Cursos/Cursos";
	}
	
	
	@GetMapping("/eliminarCurso/{index}")
	public String eliminarCurso(Model model, @PathVariable int index) {
		
		Curso cursoEliminado = repositorioCurso.findById(index);
		repositorioCurso.delete(cursoEliminado);
		
		
		return "Cursos/CursoEliminado";
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
		
		
		
		return "Cursos/informacion_curso";
	}
	
	
	@GetMapping("/crearCurso")
	public String crearCurso(Model model) {
	
		return "Cursos/Crear_Curso";
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
		return "Cursos/material_Añadido";
	}
	
	@GetMapping("/{id}/añadirMaterial")
	public String subirMaterial (Model model, @PathVariable int id){
		model.addAttribute("id", id);
		return "Cursos/subir_Material";
	}
	
	
	
	@PostMapping("/crearCursoConfirmacion")
	public String crearCursoConfirmacion(Model model, @RequestParam String titulo, @RequestParam String descripcion, HttpSession sesion) {
			
		Usuario usuario = (Usuario) sesion.getAttribute("user");
		
		Curso nuevoCurso = new Curso(titulo, descripcion, usuario);
		repositorioCurso.save(nuevoCurso);
		
		return "Cursos/Curso_Creado_Confirmacion";
	}
	
	
}
