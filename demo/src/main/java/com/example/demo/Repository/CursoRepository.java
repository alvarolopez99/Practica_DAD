package com.example.demo.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Curso;
import java.sql.Blob;

@CacheConfig(cacheNames="cacheSapiotheca")
public interface CursoRepository extends JpaRepository<Curso, Long> {
	
	@Cacheable
	List<Curso> findAll();
	
	@Cacheable
	Curso findById(long id);
	
	@CacheEvict(allEntries=true)		// Todos o sólo el curso que se elimina??
	void delete(Curso curso);
	
	@CacheEvict(allEntries=true)
	Curso save(Curso curso);
	
	Optional<Curso> findByTitulo(String titulo);
	List<Curso> findByDescripcion(String descripcion);
}


