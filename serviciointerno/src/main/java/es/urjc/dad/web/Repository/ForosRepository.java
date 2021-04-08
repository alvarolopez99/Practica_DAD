package es.urjc.dad.web.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.dad.web.Model.Foros;


public interface ForosRepository extends JpaRepository<Foros, Integer> {
}
