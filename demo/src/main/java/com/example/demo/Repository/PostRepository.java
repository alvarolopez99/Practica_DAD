package com.example.demo.Repository;
import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Foros;


public interface PostRepository extends JpaRepository<Foros, Long> {

	List<Foros> findByUsuario(long id);
}
