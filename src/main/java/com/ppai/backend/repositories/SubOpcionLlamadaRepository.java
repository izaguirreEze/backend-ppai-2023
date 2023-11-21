package com.ppai.backend.repositories;

import com.ppai.backend.entities.OpcionLlamada;
import com.ppai.backend.entities.SubOpcionLlamada;
import com.ppai.backend.entities.SubOpcionLlamadaID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubOpcionLlamadaRepository extends JpaRepository<SubOpcionLlamada, SubOpcionLlamadaID> {
    List<SubOpcionLlamada> findAllByOpcionLlamada(OpcionLlamada opcionLlamada);
}
