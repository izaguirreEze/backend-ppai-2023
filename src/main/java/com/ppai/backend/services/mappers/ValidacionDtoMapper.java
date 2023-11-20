package com.ppai.backend.services.mappers;


import com.ppai.backend.entities.Validacion;
import com.ppai.backend.entities.dto.ValidacionDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ValidacionDtoMapper implements Function<Validacion, ValidacionDto> {
    @Override
    public ValidacionDto apply(Validacion validacion) {
        return new ValidacionDto(
                validacion.getIdValidacion(),
                validacion.getNombre(),
                validacion.getSubOpcion().getId().getIdSubOpcionLlamada(),
                validacion.getSubOpcion().getOpcionLlamada().getId().getIdOpcionLlamada(),
                validacion.getSubOpcion().getCategoriaLlamada().getIdCategoriaLlamada()
        );
    }
}
