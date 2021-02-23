package com.example.demo.Model;
import javax.persistence.*;

@Entity
public class Curso {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OnetoMany
	private List<Usuario> alumnos;
	
	public Curso() {}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public void AñadirUsuario(Usuario alumno) {
		
	}
}
