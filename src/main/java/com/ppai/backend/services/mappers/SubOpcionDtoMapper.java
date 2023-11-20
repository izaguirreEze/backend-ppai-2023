package com.ppai.backend.services.mappers;


import com.ppai.backend.entities.SubOpcionLlamada;
import com.ppai.backend.entities.SubOpcionLlamadaID;
import com.ppai.backend.entities.dto.SubOpcionLlamadaDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class SubOpcionDtoMapper implements Function<SubOpcionLlamada, SubOpcionLlamadaDto> {
    @Override
    public SubOpcionLlamadaDto apply(SubOpcionLlamada subOpcionLlamada) {
        return new SubOpcionLlamadaDto(
                subOpcionLlamada.getId(),
                subOpcionLlamada.getNombre()
        );
    }
}
