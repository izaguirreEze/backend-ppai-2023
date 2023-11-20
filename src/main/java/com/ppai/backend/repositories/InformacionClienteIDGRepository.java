package com.ppai.backend.repositories;

import com.ppai.backend.entities.InformacionClienteIDGenerator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformacionClienteIDGRepository extends JpaRepository<InformacionClienteIDGenerator, Long> {
}
