package com.ppai.backend.services.mappers;

import com.ppai.backend.entities.CambioEstado;
import com.ppai.backend.entities.Estado;
import com.ppai.backend.entities.dto.EstadoDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
@Service
public class EstadoEntityMapper implements Function<EstadoDto, Estado> {
    @Override
    public Estado apply(EstadoDto estadoDto) {
        return new Estado(
                estadoDto.getIdEstado(),
                estadoDto.getNombre(),
                null
        );
    }
}
