package com.example.demo.Model;
import java.sql.Blob;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Curso {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String titulo;
	private String descripcion;
	
	private String imagen;
	
	
	public Curso (String titulo, String descripcion) {
		this.titulo = titulo;
		this.descripcion = descripcion;
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
