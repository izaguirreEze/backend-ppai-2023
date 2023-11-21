package com.ppai.backend.services.mappers;

import com.ppai.backend.entities.CambioEstado;
import com.ppai.backend.entities.dto.CambioEstadoDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class CambioEstadoEntityMapper implements Function<CambioEstadoDto, CambioEstado> {
    @Override
    public CambioEstado apply(CambioEstadoDto ce) {
        return new CambioEstado(
                ce.getIdCambioEstado(),
                ce.getFechaHoraInicio(),
                null,
                null
        );
    }
}
