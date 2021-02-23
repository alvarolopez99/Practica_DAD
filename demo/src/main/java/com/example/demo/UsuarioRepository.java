package com.example.demo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	List<Usuario> findByNombre(String nombre);	
	List<Usuario> findByPrimerApellido(String primerApellido);
	List<Usuario> findBySegundoApellido(String segundoApellido);
	
}
