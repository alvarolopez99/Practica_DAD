package com.example.demo.Model;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mysql.cj.jdbc.Blob;

@Entity
public class Foros {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String titulo;
	@ManyToOne
	private Usuario usuario;
	@Lob
	@JsonIgnore
	private Blob imagen;
	
	private String user;
	private String title;
	private String text;
	
	@OneToMany
	private List<Mensaje> mensajes;
	
	
	
	
	public Foros() {

	}

	public Foros(String user, String title, String text) {
		super();
		this.user = user;
		this.title = title;
		this.text = text;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return "Post [id="+id+", user=" + user + ", title=" + title + ", text=" + text + "]";
	}
	
	
	
	
	/*
	public Foros(Usuario usuario, Blob imagen) {
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
	}*/
}
