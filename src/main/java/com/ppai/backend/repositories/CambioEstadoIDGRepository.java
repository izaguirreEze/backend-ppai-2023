package com.ppai.backend.repositories;

import com.ppai.backend.entities.CambioEstadoIDGenerator;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CambioEstadoIDGRepository extends JpaRepository<CambioEstadoIDGenerator, Long>{
    @Modifying
    @Transactional
    @Query("UPDATE Cambios_Estados_IDGenerator c SET c.seq = c.seq + 1")
    void incrementSeq();
}
