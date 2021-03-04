package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Examen;

public interface ExamenRepository extends JpaRepository<Examen, Long> {
	
	List<Examen> findById(long id);
	List<Examen> findByCurso(long id);

}
