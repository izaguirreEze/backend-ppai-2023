package com.ppai.backend.services.mappers;


import com.ppai.backend.entities.Validacion;
import com.ppai.backend.entities.dto.ValidacionDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ValidacionEntityMapper implements Function<ValidacionDto, Validacion>{
    @Override
    public Validacion apply(ValidacionDto validacionDto) {
        return new Validacion(
                validacionDto.getId(),
                validacionDto.getNombre(),
                null
        );
    }
}
