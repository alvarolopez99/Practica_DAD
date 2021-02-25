package com.example.demo.Model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mysql.cj.jdbc.Blob;

@Entity
public class UsuarioContraseña {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private long id_usuario;
	private String contraseña;
}
