package com.example.demo.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.UsuarioContraseña;

public interface UsuarioContraseñaRepository extends JpaRepository<UsuarioContraseña, Long> {

	
}
