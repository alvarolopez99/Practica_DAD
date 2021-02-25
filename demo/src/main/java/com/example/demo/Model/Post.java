package com.example.demo.Model;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mysql.cj.jdbc.Blob;

@Entity
public class Post {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String titulo;
	@ManyToOne
	private Usuario usuario;
	@Lob
	@JsonIgnore
	private Blob imagen;
	
	@OneToMany
	private List<Mensaje> mensajes;
	
	public Post(Usuario usuario, Blob imagen) {
		this.usuario = usuario;
		this.imagen = imagen;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getTitulo() {
		return titulo;
	}
}
