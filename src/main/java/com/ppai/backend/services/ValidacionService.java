package com.ppai.backend.services;

import com.ppai.backend.entities.SubOpcionLlamadaID;
import com.ppai.backend.entities.Validacion;
import com.ppai.backend.entities.dto.ValidacionDto;

import java.util.List;

public interface ValidacionService extends Service<ValidacionDto, Long>{
    public List<ValidacionDto> getAllByIdSubOpcion(Long idSubo, Long idOpcion, Long idCategoria);
}
