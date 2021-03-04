package com.example.demo.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
	
	List<Curso> findById(long id);
	List<Curso> findByTitulo(String titulo);
	List<Curso> findByDescripcion(String descripcion);
	List<Curso> findByImagen(String imagen);
	
}


