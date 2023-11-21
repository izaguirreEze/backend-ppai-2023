package com.ppai.backend.services;

import com.ppai.backend.entities.SubOpcionLlamada;
import com.ppai.backend.entities.SubOpcionLlamadaID;
import com.ppai.backend.entities.dto.SubOpcionLlamadaDto;

import java.util.List;

public interface SubOpcionLlamadaService extends Service<SubOpcionLlamadaDto, SubOpcionLlamadaID>{
    List<SubOpcionLlamadaDto> getAllByIdOpcion(Long idOpcion, Long idCategoria);
}
