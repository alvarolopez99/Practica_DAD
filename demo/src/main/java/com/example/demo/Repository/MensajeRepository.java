package com.example.demo.Repository;
import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Mensaje;


public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

	List<Mensaje> findByEmisor(long id);
}
