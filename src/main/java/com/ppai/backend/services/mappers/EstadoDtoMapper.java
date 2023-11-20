package com.ppai.backend.services.mappers;

import com.ppai.backend.entities.Estado;
import com.ppai.backend.entities.dto.EstadoDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class EstadoDtoMapper implements Function<Estado, EstadoDto> {

    @Override
    public EstadoDto apply(Estado estado) {
        return new EstadoDto(
                estado.getId(),
                estado.getNombre()
        );
    }
}
