package com.example.demo.Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Curso implements Serializable{

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
	
	private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException 
    {       
    	id = aInputStream.readLong();
    	
    	titulo = aInputStream.readUTF();
    	creador = aInputStream.readUTF();
    	descripcion = aInputStream.readUTF();
    	
    	archivo = (ArrayList<Blob>)aInputStream.readObject();
    	
    	profesor = (Usuario)aInputStream.readObject();
    	
    	alumnos = (List<Usuario>)aInputStream.readObject();
    	examenes = (List<Examen>)aInputStream.readObject();

    }
 
    private void writeObject(ObjectOutputStream aOutputStream) throws IOException 
    {
    	aOutputStream.writeLong(id);
    	aOutputStream.writeUTF(titulo);
    	aOutputStream.writeUTF(creador);
    	aOutputStream.writeUTF(descripcion);
    	
    	aOutputStream.writeObject(archivo);
        aOutputStream.writeObject(profesor);
        aOutputStream.writeObject(alumnos);
        aOutputStream.writeObject(examenes);

        
    }
	
}
