package com.example.demo.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Foros;

public interface ForosRepository extends JpaRepository<Foros, Integer> {
	
	List<Foros> findAll();
	
	Optional<Foros> findById(int id);
	
	
	Foros save(Foros foro);
	
}
