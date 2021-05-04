package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.Model.Usuario;

@CacheConfig(cacheNames="cacheSapiotheca")
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	Optional<Usuario> findByNombre(String nombre);	
	List<Usuario> findByPrimerApellido(String primerApellido);
	List<Usuario> findBySegundoApellido(String segundoApellido);
	
	@Cacheable
	Optional<Usuario> findByCorreo(String correo);
	
	@CacheEvict(allEntries=true)
	Usuario save(Usuario usuario);
	
}
