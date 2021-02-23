package com.example.demo.Model;
import javax.persistence.*;

@Entity
public class Chat {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManytoOne
	private long Usuario profesor;
	
	@ManytoOne
	private long Usuario alumno;
	
	private String cuerpoMensaje;
	
	public Chat(Usuario profesor, Usuario alumno, String cuerpoMensaje) {
		this.profesor = profesor;
		this.alumno = alumno;
		this.cuerpoMensaje = cuerpoMensaje;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
