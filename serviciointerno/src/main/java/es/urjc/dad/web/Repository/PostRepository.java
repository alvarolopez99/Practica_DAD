package es.urjc.dad.web.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.dad.web.Model.Foros;


public interface PostRepository extends JpaRepository<Foros, Long> {

	List<Foros> findByUsuario(long id);
}
