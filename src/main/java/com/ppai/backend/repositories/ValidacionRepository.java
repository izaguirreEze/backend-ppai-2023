package com.ppai.backend.repositories;

import com.ppai.backend.entities.SubOpcionLlamada;
import com.ppai.backend.entities.Validacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ValidacionRepository extends JpaRepository<Validacion, Long> {
    List<Validacion> findAllBySubOpcion(SubOpcionLlamada subOpcion);
}
