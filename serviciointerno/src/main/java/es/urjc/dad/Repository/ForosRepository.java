package es.urjc.dad.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.dad.Model.Foros;


public interface ForosRepository extends JpaRepository<Foros, Integer> {
}
