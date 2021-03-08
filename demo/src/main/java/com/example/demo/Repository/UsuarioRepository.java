package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByNombre(String nombre);	
	List<Usuario> findByPrimerApellido(String primerApellido);
	List<Usuario> findBySegundoApellido(String segundoApellido);
	Optional<Usuario> findByCorreo(String correo);
	
}
