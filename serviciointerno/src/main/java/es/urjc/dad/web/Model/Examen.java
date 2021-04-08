package es.urjc.dad.web.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Examen {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Pregunta> preguntas = new ArrayList<Pregunta>();
	
	@OneToOne
	private Curso curso;
	
	public Examen() {}
	public Examen(Curso curso) {
		this.curso = curso;
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public void addPregunta(Pregunta p) {
		preguntas.add(p);
	}
	
	public List<Pregunta> getPreguntas(){
		return preguntas;
	}
	
	public void setCurso(Curso c) {
		curso = c;
	}
	
	public Curso getCurso() {
		return curso;
	}

}
