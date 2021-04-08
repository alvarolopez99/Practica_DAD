package es.urjc.dad.web.Repository;
import java.util.List;

import javax.persistence.ManyToOne;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.dad.web.Model.Anuncio;
import es.urjc.dad.web.Model.Usuario;


public interface AnuncioRepository extends JpaRepository<Anuncio, Integer> {
	
	//consultas personalizadas
	
	
	
	List<Anuncio> findByprofesor(Usuario profesor);

	List<Anuncio> findBycontenido(String contenido);
	
	List<Anuncio> findBymateria(String materia);
	
	List<Anuncio> findByhorario(String horario);
	
	List<Anuncio> findByprecio(String precio);
	
	List<Anuncio> findBycurso(String curso);

	//Generar la consulta a SQL automaticamente en base a esta informacion
	//Interfaz de la clase que vamos a persistir
	//Usar este objeto para guardar o recuperar de la BD
}
