package com.example.demo.Model;
import javax.persistence.*;

@Entity
public class Post {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManytoOne
	private Usuario usuario;
	
	public Post() {}
	
}
