package es.urjc.dad.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.dad.Model.Chat;
import es.urjc.dad.Model.Usuario;


public interface ChatRepository  extends JpaRepository<Chat, Long> {

	Optional<Chat> findById(long id);
	List<Chat> findByProfesor(Usuario u);
	List<Chat> findByAlumno(Usuario u);
	
	Optional<Chat> findByProfesorAndAlumno(Usuario u1, Usuario u2);
	
	
}
