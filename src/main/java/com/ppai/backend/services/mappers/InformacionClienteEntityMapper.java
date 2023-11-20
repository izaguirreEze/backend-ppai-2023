package com.ppai.backend.services.mappers;

import com.ppai.backend.entities.InformacionCliente;
import com.ppai.backend.entities.dto.InformacionClienteDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class InformacionClienteEntityMapper implements Function<InformacionClienteDto, InformacionCliente> {
    @Override
    public InformacionCliente apply(InformacionClienteDto informacionClienteDto) {
        return new InformacionCliente(
                informacionClienteDto.getId(),
                informacionClienteDto.getDatoAValidar(),
                null,
                null
        );
    }
}
