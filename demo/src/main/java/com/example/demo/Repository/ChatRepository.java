package com.example.demo.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Anuncio;
import com.example.demo.Model.Chat;
import com.example.demo.Model.Usuario;

@CacheConfig(cacheNames="cacheSapiotheca")
public interface ChatRepository  extends JpaRepository<Chat, Long> {

	@Cacheable(key="#root.method.name+#root.target+#id")
	Optional<Chat> findById(long id);
	
	@CacheEvict(allEntries=true)
	Chat save(Chat chat);
	
	@Cacheable
	List<Chat> findByProfesor(Usuario u);
	List<Chat> findByAlumno(Usuario u);
	
	@Cacheable
	Optional<Chat> findByProfesorAndAlumno(Usuario u1, Usuario u2);
	
	
}
