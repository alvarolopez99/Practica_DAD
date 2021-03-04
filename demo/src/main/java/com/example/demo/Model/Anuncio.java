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
	
	private String titulo;
	private String horario;
	
	public Anuncio() {}
	
	public Anuncio(Usuario profesor, String titulo, String contenido) {
		this.profesor = profesor;
		this.titulo = titulo;
		this.contenido = contenido;
	}
	
	public Usuario getProfesor() {
		return profesor;
	}

	public void setProfesor(Usuario profesor) {
		this.profesor = profesor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
