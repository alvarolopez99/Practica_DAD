package es.urjc.dad.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.dad.Model.Curso;

import java.sql.Blob;


public interface CursoRepository extends JpaRepository<Curso, Long> {
	
	Curso findById(long id);
	Optional<Curso> findByTitulo(String titulo);
	List<Curso> findByDescripcion(String descripcion);
}


