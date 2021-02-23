package com.example.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}


