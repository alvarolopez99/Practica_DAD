package com.example.demo.Model;
import java.util.ArrayList;
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
	

	
	
	//******************************//
	
	//private String user;
	private String asunto;
	private String cuerpo;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Mensaje> mensajes;

	@ManyToOne
	private Usuario creador;
	
	//******************************//	

	
	public Foros() {

	}

	public Foros(String title, String text, Usuario creador) {
		super();
		this.creador = creador;
		this.asunto = title;
		this.cuerpo = text;
		this.mensajes = new ArrayList<Mensaje>();
	}
	
	/*public String getUser() {
		return user;
	}*/

	/*public void setUser(String user) {
		this.user = user;
	}/*/
	
	public void AñadirMensaje(Mensaje mensaje) {
		mensajes.add(mensaje);
	}
	
	public ArrayList getMensajes() {
		return (ArrayList) mensajes;
	}


	public String getTitle() {
		return asunto;
	}

	public void setTitle(String title) {
		this.asunto = title;
	}

	public String getText() {
		return cuerpo;
	}

	public void setText(String text) {
		this.cuerpo = text;
	}
	
	@Override
	public String toString() {
		return "Post [id="+id+", user=" + "user" + ", title=" + asunto + ", text=" + cuerpo + "]";
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
