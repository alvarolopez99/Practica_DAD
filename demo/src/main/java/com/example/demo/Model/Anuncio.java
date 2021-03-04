package com.example.demo.Model;
import javax.persistence.*;

@Entity 
public class Anuncio {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;	
	private String contenido;	
	@ManyToOne
	private Usuario profesor;	
	private String materia;
	private String horario;
	private String precio;
	private String curso;
	
	public Anuncio() {}
	
	public Anuncio(Usuario profesor, String materia, String contenido, String horario, String precio, String curso) {
		this.profesor = profesor;
		this.materia = materia;
		this.contenido = contenido;
		this.horario = horario;
		this.precio = precio;
		this.curso = curso;
	}
	
	public Anuncio(String materia, String contenido, String horario, String precio, String curso) {

		this.materia = materia;
		this.contenido = contenido;
		this.horario = horario;
		this.precio = precio;
		this.curso = curso;
	}
	
	
	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public Usuario getProfesor() {
		return profesor;
	}

	public void setProfesor(Usuario profesor) {
		this.profesor = profesor;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Anuncio(String contenido) {
		this.contenido = contenido;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	public String getContenido() {
		return contenido;
	}
	
	

}
