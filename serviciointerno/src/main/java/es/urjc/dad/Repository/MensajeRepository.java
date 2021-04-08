package es.urjc.dad.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.dad.Model.Mensaje;


public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

	List<Mensaje> findByEmisor(long id);
}
