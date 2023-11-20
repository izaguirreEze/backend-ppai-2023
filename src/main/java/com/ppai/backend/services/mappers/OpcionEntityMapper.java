package com.ppai.backend.services.mappers;


import com.ppai.backend.entities.OpcionLlamada;
import com.ppai.backend.entities.dto.OpcionLlamadaDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class OpcionEntityMapper implements Function<OpcionLlamadaDto, OpcionLlamada> {
    @Override
    public OpcionLlamada apply(OpcionLlamadaDto opcionLlamadaDto) {
        return new OpcionLlamada(
                opcionLlamadaDto.getId(),
                opcionLlamadaDto.getNombre(),
                null,
                null
        );
    }
}
