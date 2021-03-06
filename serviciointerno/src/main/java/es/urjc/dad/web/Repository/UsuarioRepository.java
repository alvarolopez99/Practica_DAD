package es.urjc.dad.web.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import es.urjc.dad.web.Model.Usuario;


public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	Optional<Usuario> findByNombre(String nombre);	
	List<Usuario> findByPrimerApellido(String primerApellido);
	List<Usuario> findBySegundoApellido(String segundoApellido);
	Optional<Usuario> findByCorreo(String correo);
	
}
