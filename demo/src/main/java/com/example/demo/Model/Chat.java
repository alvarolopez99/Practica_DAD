package com.example.demo.Model;
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
