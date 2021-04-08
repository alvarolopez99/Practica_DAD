package es.urjc.dad.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.dad.Model.Curso;
import es.urjc.dad.Model.Examen;

public interface ExamenRepository extends JpaRepository<Examen, Long> {
	
	List<Examen> findById(long id);
	Optional<Examen> findByCurso(Curso c);

}
