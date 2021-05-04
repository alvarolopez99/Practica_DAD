package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Curso;
import com.example.demo.Model.Examen;

@CacheConfig(cacheNames="cacheSapiotheca")
public interface ExamenRepository extends JpaRepository<Examen, Long> {
	
	List<Examen> findById(long id);
	
	@Cacheable
	Optional<Examen> findByCurso(Curso c);

	@CacheEvict(allEntries=true)			// Todos o sólo ese examen?
	void delete(Examen examen);
	
	@CacheEvict(allEntries=true)	
	Examen save(Examen examen);
	
}
