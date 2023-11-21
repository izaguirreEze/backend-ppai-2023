package com.ppai.backend.repositories;

import com.ppai.backend.entities.CategoriaLlamada;
import com.ppai.backend.entities.OpcionLlamada;
import com.ppai.backend.entities.OpcionLlamadaID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpcionLlamadaRepository extends JpaRepository<OpcionLlamada, OpcionLlamadaID> {
    List<OpcionLlamada> findAllByCategoriaLlamada(CategoriaLlamada categoriaLlamada);
}
