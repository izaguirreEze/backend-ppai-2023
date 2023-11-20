package com.ppai.backend.services.mappers;

import com.ppai.backend.entities.CambioEstado;
import com.ppai.backend.entities.dto.CambioEstadoDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class CambioEstadoDtoMapper implements Function<CambioEstado, CambioEstadoDto> {
    @Override
    public CambioEstadoDto apply(CambioEstado cambioEstado) {
        return  new CambioEstadoDto(
                cambioEstado.getId(),
                cambioEstado.getEstado().getNombre(),
                cambioEstado.getFechaHoraInicio()
        );
    }
}

