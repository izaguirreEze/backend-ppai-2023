package com.ppai.backend.services.mappers;

import com.ppai.backend.entities.Cliente;
import com.ppai.backend.entities.dto.ClienteDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service

public class ClienteDtoMapper implements Function<Cliente, ClienteDto> {
    @Override
    public ClienteDto apply(Cliente cliente) {
        return new ClienteDto(
                cliente.getNroDocumento(),
                cliente.getNombreCompleto()
        );
    }
}
