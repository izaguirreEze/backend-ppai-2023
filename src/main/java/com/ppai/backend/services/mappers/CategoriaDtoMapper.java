package com.ppai.backend.services.mappers;

import com.ppai.backend.entities.CategoriaLlamada;
import com.ppai.backend.entities.dto.CategoriaLlamadaDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CategoriaDtoMapper implements Function<CategoriaLlamada, CategoriaLlamadaDto>{
    @Override
    public CategoriaLlamadaDto apply(CategoriaLlamada categoriaLlamada) {
        return new CategoriaLlamadaDto(
                categoriaLlamada.getIdCategoriaLlamada(),
                categoriaLlamada.getNombre()
        );
    }
}
