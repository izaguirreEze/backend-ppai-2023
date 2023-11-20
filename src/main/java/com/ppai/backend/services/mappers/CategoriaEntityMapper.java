package com.ppai.backend.services.mappers;

import com.ppai.backend.entities.CategoriaLlamada;
import com.ppai.backend.entities.dto.CategoriaLlamadaDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service

public class CategoriaEntityMapper implements Function<CategoriaLlamadaDto, CategoriaLlamada> {
    @Override
    public CategoriaLlamada apply(CategoriaLlamadaDto categoriaLlamadaDto) {
        return new CategoriaLlamada(
                categoriaLlamadaDto.getId(),
                categoriaLlamadaDto.getNombre(),
                null,
                null,
                null
        );
    }
}
