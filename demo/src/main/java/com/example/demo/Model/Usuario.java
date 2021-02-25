package com.example.demo.Model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mysql.cj.jdbc.Blob;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String contraseña;
	private int tipoUsuario;
	private int tipoSuscripcion;
	private String correo;
	private int metodoPago;
	@Lob
	@JsonIgnore
	private Blob fotoPerfil;
	
	//@OneToOne(cascade=CascadeType.ALL)
	//private UsuarioContraseña uc
	
	public Usuario() {
		
	}
	
	public Usuario(String nombre, String primerApellido, String segundoApellido, String contraseña,
			int tipoUsuario, int tipoSuscripcion, String correo, int metodoPago, Blob fotoPerfil) {
		super();
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.contraseña = contraseña;
		this.tipoUsuario = tipoUsuario;
		this.tipoSuscripcion = tipoSuscripcion;
		this.correo = correo;
		this.metodoPago = metodoPago;
		this.fotoPerfil = fotoPerfil;
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
	
	public int getUsuario() {
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
		return contraseña;
	}
	
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

}
