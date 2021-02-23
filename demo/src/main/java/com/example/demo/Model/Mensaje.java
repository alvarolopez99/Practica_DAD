package com.example.demo.Model;
import javax.persistence.*;


@Entity
public class Mensaje {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private Usuario emisor;
	
	@ManyToOne
	private Usuario receptor;
	
	public Mensaje(Usuario emisor, Usuario receptor) {
		this.emisor = emisor;
		this.receptor = receptor;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
}
