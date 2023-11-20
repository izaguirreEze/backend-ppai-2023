package com.ppai.backend.repositories;

import com.ppai.backend.entities.CambioEstado;
import com.ppai.backend.entities.CambioEstadoID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CambioEstadoRepository extends JpaRepository<CambioEstado, CambioEstadoID> {
}
