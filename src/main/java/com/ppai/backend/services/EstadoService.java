package com.ppai.backend.services;


import com.ppai.backend.entities.Estado;
import com.ppai.backend.entities.dto.EstadoDto;

public interface EstadoService extends Service<EstadoDto, Long>{
    EstadoDto add(EstadoDto entity);
}
