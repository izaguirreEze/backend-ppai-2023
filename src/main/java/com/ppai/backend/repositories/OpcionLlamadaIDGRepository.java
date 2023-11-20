package com.ppai.backend.repositories;

import com.ppai.backend.entities.OpcionLlamadaIDGenerator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpcionLlamadaIDGRepository extends JpaRepository<OpcionLlamadaIDGenerator, Long> {
}
