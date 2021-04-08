package es.urjc.dad.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.dad.Model.Foros;


public interface PostRepository extends JpaRepository<Foros, Long> {

	List<Foros> findByUsuario(long id);
}
