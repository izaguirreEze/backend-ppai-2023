package com.ppai.backend.repositories;

import com.ppai.backend.entities.OpcionLlamada;
import com.ppai.backend.entities.OpcionLlamadaID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpcionLlamadaRepository extends JpaRepository<OpcionLlamada, OpcionLlamadaID> {
}
