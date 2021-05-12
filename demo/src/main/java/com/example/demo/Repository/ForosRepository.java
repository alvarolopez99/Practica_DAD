package com.example.demo.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Foros;

@CacheConfig(cacheNames="cacheSapiotheca")
public interface ForosRepository extends JpaRepository<Foros, Integer> {
	
	@Cacheable(key="#root.method.name+#root.target")
	List<Foros> findAll();
	
	@Cacheable(key="#root.method.name+#root.target+#id")
	Optional<Foros> findById(int id);
	
	@CacheEvict(allEntries=true)
	Foros save(Foros foro);
	
}
