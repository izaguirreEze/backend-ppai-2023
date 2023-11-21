package com.ppai.backend.services.mappers;


import com.ppai.backend.entities.SubOpcionLlamada;
import com.ppai.backend.entities.dto.SubOpcionLlamadaDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class SubOpcionEntityMapper implements Function<SubOpcionLlamadaDto, SubOpcionLlamada> {
    @Override
    public SubOpcionLlamada apply(SubOpcionLlamadaDto subOpcionLlamadaDto) {
        return new SubOpcionLlamada(
                subOpcionLlamadaDto.getId(),
                subOpcionLlamadaDto.getNombre(),
                null,
                null,
                null
        );
    }
}
