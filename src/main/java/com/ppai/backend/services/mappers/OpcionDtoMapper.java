package com.ppai.backend.services.mappers;


import com.ppai.backend.entities.OpcionLlamada;
import com.ppai.backend.entities.dto.OpcionLlamadaDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class OpcionDtoMapper implements Function<OpcionLlamada, OpcionLlamadaDto> {
    @Override
    public OpcionLlamadaDto apply(OpcionLlamada opcionLlamada) {
        return new OpcionLlamadaDto(
                opcionLlamada.getId(),
                opcionLlamada.getNombre()
        );
    }
}
