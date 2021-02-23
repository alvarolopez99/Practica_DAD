package com.example.demo.Model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mysql.cj.jdbc.Blob;

@Entity
public class Post {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManytoOne
	private Usuario usuario;
	
	@Lob
	@JsonIgnore
	private Blob imagen;
	
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
}
