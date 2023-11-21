package com.ppai.backend.services;

import com.ppai.backend.entities.OpcionLlamada;
import com.ppai.backend.entities.OpcionLlamadaID;
import com.ppai.backend.entities.dto.OpcionLlamadaDto;

import java.util.List;

public interface OpcionLlamadaService extends Service<OpcionLlamadaDto, OpcionLlamadaID>{
    public List<OpcionLlamadaDto> getAllByIdCategoria(Long idCategoria);
}
