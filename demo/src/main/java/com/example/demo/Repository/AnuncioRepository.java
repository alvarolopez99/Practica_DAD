package com.example.demo.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Anuncio;

public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {
	
	List<Anuncio> findById(long id);
	List<Anuncio> findByContenido(String contenido);
	
}
