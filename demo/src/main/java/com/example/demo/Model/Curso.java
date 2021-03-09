package com.example.demo.Model;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Curso {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String titulo;
	private String creador;

	private String descripcion;
	
	private String imagen;
	
	
	@ManyToOne
	private Usuario profesor;
	
	@OneToMany
	private List <Usuario> alumnos;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	private List <Examen> examenes;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	private List <Material> materiales;
	
	public Curso (String titulo, String descripcion, Usuario profesor) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		if (profesor != null) {
			this.profesor = profesor;
			creador = profesor.getNombre();
		}
		alumnos = new ArrayList<Usuario>();
		examenes = new ArrayList<Examen>();
		materiales = new ArrayList<Material>();
	}
	
	public void AñadirExamen(Examen examen) {
		examenes.add(examen);
	}
	
	public void AñadirAlumno(Usuario alumno) {
		alumnos.add(alumno);
	}
	
	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String image) {
		this.imagen = image;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getProfesor() {
		return profesor.getNombre();
	}
	/*
	@OneToMany
	private List<Usuario> alumnos;
	*/
	
	/*
	@OneToMany
	private List<Material> materiales;
	*/
	
	public Curso() {}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	/*
	public void AñadirUsuario(Usuario alumno) {
		
	} 
	*/
	
	/*
	public void AñadirMaterial(Material material) {
		materiales.add(material);
	}
	
	public List<Material> getMateriales() {
		return materiales;
	}
	*/
}
