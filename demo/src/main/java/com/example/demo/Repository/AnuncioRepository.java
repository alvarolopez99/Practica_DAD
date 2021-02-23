package com.example.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Anuncio;

public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

}
