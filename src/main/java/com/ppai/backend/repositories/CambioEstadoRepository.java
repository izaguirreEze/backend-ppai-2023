package com.ppai.backend.repositories;

import com.ppai.backend.entities.CambioEstado;
import com.ppai.backend.entities.CambioEstadoID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CambioEstadoRepository extends JpaRepository<CambioEstado, CambioEstadoID> {
    List<CambioEstado> findAllById_IdLlamada(long aLong);
}
