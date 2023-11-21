package com.ppai.backend.services.mappers;

import com.ppai.backend.entities.InformacionCliente;
import com.ppai.backend.entities.dto.InformacionClienteDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service

public class InformacionClienteDtoMapper implements Function<InformacionCliente, InformacionClienteDto> {
    @Override
    public InformacionClienteDto apply(InformacionCliente informacionCliente) {
        return new InformacionClienteDto(
                informacionCliente.getId(),
                informacionCliente.getValidacion().getIdValidacion(),
                informacionCliente.getDatoAValidar()
        );
    }
}
