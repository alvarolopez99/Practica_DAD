package es.urjc.dad.web.Model;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Curso {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String titulo;
	private String creador;
	private String descripcion;	
	@Lob
	@JsonIgnore
	private ArrayList<Blob> archivo;
	
	
	@ManyToOne
	private Usuario profesor;
	
	@OneToMany
	private List <Usuario> alumnos;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	private List <Examen> examenes;
	
	
	public Curso (String titulo, String descripcion, Usuario profesor) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		if (profesor != null) {
			this.profesor = profesor;
			creador = profesor.getNombre();
		}
		alumnos = new ArrayList<Usuario>();
		examenes = new ArrayList<Examen>();
		archivo = new ArrayList<Blob>();
	}
	
	public void AñadirExamen(Examen examen) {
		examenes.add(examen);
	}
	
	public void AñadirAlumno(Usuario alumno) {
		alumnos.add(alumno);
	}
	
	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	public ArrayList<Blob> getArchivos() {
		return archivo;
	}

	public void setArchivo(ArrayList<Blob> archivo) {
		this.archivo = archivo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getProfesor() {
		return profesor.getNombre();
	}
	
	public Curso() {}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
