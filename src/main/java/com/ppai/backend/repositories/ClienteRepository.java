package com.ppai.backend.repositories;

import com.ppai.backend.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
