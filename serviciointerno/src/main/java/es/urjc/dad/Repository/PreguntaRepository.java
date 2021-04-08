package es.urjc.dad.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.dad.Model.Pregunta;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
	
	List<Pregunta> findById(long id);
	List<Pregunta> findByEnunciado(String enunciado);
	List<Pregunta> findByRespuesta(String respuesta);

}
