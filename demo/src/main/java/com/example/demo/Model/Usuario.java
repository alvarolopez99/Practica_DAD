package com.example.demo.Model;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Repository.CursoRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String contraseñaCodificada;
	private int tipoUsuario;	//0: Alumno - 1:Profesor
	private int tipoSuscripcion;	//0: Estándar - 1:Premium
	private String correo;
	private int metodoPago;		//0: Crédito - 1:Paypal
	@Lob
	@JsonIgnore
	private Blob fotoPerfil;
	
	@OneToMany
	private List<Curso> cursos;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;
	

	public Usuario() {
		
	}
	
	public Usuario(String nombre, String primerApellido, String segundoApellido, String contraseña,
			int tipoUsuario, int tipoSuscripcion, String correo, int metodoPago, Blob fotoPerfil, String... roles) {
		super();
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.contraseñaCodificada = contraseña;
		this.tipoUsuario = tipoUsuario;
		this.tipoSuscripcion = tipoSuscripcion;
		this.correo = correo;
		this.metodoPago = metodoPago;
		this.fotoPerfil = fotoPerfil;
		this.roles = List.of(roles);
		//cursos = new ArrayList<Curso>();
	}
	
	public long getId() {
		return id;
	}
	
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(int metodoPago) {
		this.metodoPago = metodoPago;
	}

	public Blob getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(Blob fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public int getTipoSuscripcion() {
		return tipoSuscripcion;
	}

	public void setTipoSuscripcion(int tipoSuscripcion) {

		this.tipoSuscripcion = tipoSuscripcion;
	}
	
	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getContraseña() {
		return contraseñaCodificada;
	}
	
	public void setContraseña(String contraseña) {
		this.contraseñaCodificada = contraseña;
	}
	
	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
<<<<<<< HEAD
=======
	
	private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException 
    {       
    	id = aInputStream.readLong();
    	
    	nombre = aInputStream.readUTF();
    	primerApellido = aInputStream.readUTF();
    	segundoApellido = aInputStream.readUTF();
    	contraseñaCodificada = aInputStream.readUTF();
    	
    	tipoUsuario = aInputStream.readInt();
    	tipoSuscripcion = aInputStream.readInt();
    	
    	correo = aInputStream.readUTF();
    	
    	metodoPago = aInputStream.readInt();
    }
 
    private void writeObject(ObjectOutputStream aOutputStream) throws IOException 
    {
    	aOutputStream.writeLong(id);
        aOutputStream.writeUTF(nombre);
        aOutputStream.writeUTF(primerApellido);
        aOutputStream.writeUTF(segundoApellido);
        aOutputStream.writeUTF(contraseñaCodificada);
        
        aOutputStream.writeInt(tipoUsuario);
        aOutputStream.writeInt(tipoSuscripcion);
        
        aOutputStream.writeUTF(correo);
        
        aOutputStream.writeInt(metodoPago);  
    }
<<<<<<< HEAD
>>>>>>> parent of 61e688a (cache 3)
=======
>>>>>>> parent of 61e688a (cache 3)

}
