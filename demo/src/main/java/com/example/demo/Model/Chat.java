package com.example.demo.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Chat {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private Usuario profesor;
	
	@ManyToOne
	private Usuario alumno;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Mensaje> mensajes;
	
	public Chat(Usuario profesor, Usuario alumno, String cuerpoMensaje) {
		this.profesor = profesor;
		this.alumno = alumno;
		mensajes = new ArrayList<Mensaje>();
	}
	
	public void AñadirMensaje(Mensaje mensaje) {
		mensajes.add(mensaje);
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public List<Mensaje> getMensajes(){
		return mensajes;
	}
	
	
}
