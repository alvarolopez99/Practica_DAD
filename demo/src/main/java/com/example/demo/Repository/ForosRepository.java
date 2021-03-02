package com.example.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Foros;

public interface ForosRepository extends JpaRepository<Foros, Long> {
}
