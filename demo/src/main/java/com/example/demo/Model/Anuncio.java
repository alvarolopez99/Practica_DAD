package com.example.demo.Model;
import javax.persistence.*;

@Entity 
public class Anuncio {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	public Anuncio() {}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	

}
