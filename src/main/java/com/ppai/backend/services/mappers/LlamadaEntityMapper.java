package com.ppai.backend.services.mappers;


import com.ppai.backend.entities.Llamada;
import com.ppai.backend.entities.dto.LlamadaDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class LlamadaEntityMapper implements Function<LlamadaDto, Llamada> {
    @Override
    public Llamada apply(LlamadaDto llamadaDto) {
        Long duracion = null;
        String descripcionOperador = null;
        String detalleAccionRequerida = null;

        if(llamadaDto.getDuracion() != null) duracion = llamadaDto.getDuracion();
        if(llamadaDto.getDescipcionOperador() != null) descripcionOperador = llamadaDto.getDescipcionOperador();
        if(llamadaDto.getDetalleAccionRequerida() != null) detalleAccionRequerida = llamadaDto.getDetalleAccionRequerida();
        return new Llamada(
                llamadaDto.getIdLlamada(),
                duracion,
                descripcionOperador,
                detalleAccionRequerida,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }
}
