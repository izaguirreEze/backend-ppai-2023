package com.ppai.backend.services;

import com.ppai.backend.entities.CambioEstadoID;
import com.ppai.backend.entities.dto.CambioEstadoDto;

import java.util.List;

public interface CambioEstadoService extends Service<CambioEstadoDto, CambioEstadoID>{
    public List<CambioEstadoDto> getAllByIdLlamada(long idLlamada);
}
