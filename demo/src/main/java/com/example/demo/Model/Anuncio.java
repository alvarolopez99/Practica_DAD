package com.example.demo.Model;

@Entity 
public class Anuncio {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	

}
