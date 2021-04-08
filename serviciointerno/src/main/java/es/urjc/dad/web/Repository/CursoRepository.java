package es.urjc.dad.web.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.dad.web.Model.Curso;

import java.sql.Blob;


public interface CursoRepository extends JpaRepository<Curso, Long> {
	
	Curso findById(long id);
	Optional<Curso> findByTitulo(String titulo);
	List<Curso> findByDescripcion(String descripcion);
}


