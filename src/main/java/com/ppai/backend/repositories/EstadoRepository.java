package com.ppai.backend.repositories;

import com.ppai.backend.entities.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
    Optional<Estado> findFirstByNombre(String nombre);
}
