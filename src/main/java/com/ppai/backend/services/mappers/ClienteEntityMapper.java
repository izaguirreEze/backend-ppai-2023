package com.ppai.backend.services.mappers;

import com.ppai.backend.entities.Cliente;
import com.ppai.backend.entities.dto.ClienteDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service

public class ClienteEntityMapper implements Function<ClienteDto, Cliente> {
    @Override
    public Cliente apply(ClienteDto clienteDto) {
        return new Cliente(
                clienteDto.getNroDocumento(),
                clienteDto.getNombre_completo(),
                null,
                null
        );
    }
}
