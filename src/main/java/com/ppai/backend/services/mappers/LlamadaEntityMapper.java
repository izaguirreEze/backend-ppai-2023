package com.ppai.backend.services.mappers;


import com.ppai.backend.entities.Llamada;
import com.ppai.backend.entities.dto.LlamadaDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class LlamadaEntityMapper implements Function<LlamadaDto, Llamada> {
    @Override
    public Llamada apply(LlamadaDto llamadaDto) {
        return new Llamada(
                llamadaDto.getId(),
                llamadaDto.getDuracion(),
                llamadaDto.getDescipcionOperador(),
                llamadaDto.getDetalleAccionRequerida(),
                null,
                null,
                null,
                null,
                null,
                null
        );
    }
}
