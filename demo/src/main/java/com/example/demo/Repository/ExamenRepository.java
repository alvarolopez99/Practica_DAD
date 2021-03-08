package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Curso;
import com.example.demo.Model.Examen;

public interface ExamenRepository extends JpaRepository<Examen, Long> {
	
	List<Examen> findById(long id);
	Optional<Examen> findByCurso(Curso c);

}
