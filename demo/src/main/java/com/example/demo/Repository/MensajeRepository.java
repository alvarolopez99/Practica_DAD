package com.example.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Mensaje;

public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

}
