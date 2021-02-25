package com.example.demo.Model;
import javax.persistence.*;

@Entity 
public class Anuncio {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String contenido;
	
	public Anuncio() {}
	
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
