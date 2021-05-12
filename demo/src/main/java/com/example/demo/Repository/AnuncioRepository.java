package com.example.demo.Repository;
import java.util.List;
import java.util.Optional;

import javax.persistence.ManyToOne;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Anuncio;
import com.example.demo.Model.Usuario;

@CacheConfig(cacheNames="cacheSapiotheca")
public interface AnuncioRepository extends JpaRepository<Anuncio, Integer> {
	
	@Cacheable(key="#root.method.name+#root.target+#id")
	Optional<Anuncio> findById(int id);
	
	@Cacheable(key="#root.method.name+#root.target")
	List<Anuncio> findAll();
	
	@CacheEvict(allEntries=true)
	Anuncio save(Anuncio anuncio);
	
	@CacheEvict
	Anuncio deleteById(int id);
	
	
	// Consultas personalizadas
	
	List<Anuncio> findByprofesor(Usuario profesor);

	List<Anuncio> findBycontenido(String contenido);
	
	List<Anuncio> findBymateria(String materia);
	
	List<Anuncio> findByhorario(String horario);
	
	List<Anuncio> findByprecio(String precio);

	List<Anuncio> findBycurso(String curso);


	//Generar la consulta a SQL automaticamente en base a esta informacion
	//Interfaz de la clase que vamos a persistir
	//Usar este objeto para guardar o recuperar de la BD
}
