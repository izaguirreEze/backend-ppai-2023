package com.ppai.backend.services;

import com.ppai.backend.entities.CategoriaLlamada;
import com.ppai.backend.entities.Cliente;
import com.ppai.backend.entities.InformacionCliente;
import com.ppai.backend.entities.Validacion;
import com.ppai.backend.entities.dto.ClienteDto;
import com.ppai.backend.repositories.ClienteRepository;
import com.ppai.backend.services.mappers.ClienteDtoMapper;
import com.ppai.backend.services.mappers.ClienteEntityMapper;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;
    private final ClienteDtoMapper dtoMapper;
    private final ClienteEntityMapper entityMapper;

    public ClienteServiceImpl(ClienteRepository clienteRepository, ClienteDtoMapper dtoMapper, ClienteEntityMapper entityMapper) {
        this.clienteRepository = clienteRepository;
        this.dtoMapper = dtoMapper;
        this.entityMapper = entityMapper;
    }


    @Override
    public ClienteDto add(ClienteDto entity) {
        if (entity == null)
            throw new InvalidParameterException();

        Optional<Cliente> clientEntity = Stream.of(entity).map(entityMapper).findFirst();

        clientEntity.ifPresent(this.clienteRepository::save);

        return clientEntity.map(dtoMapper).orElseThrow();
    }

    @Override
    public ClienteDto update(ClienteDto entity) {
        return null;
    }

    @Override
    public ClienteDto delete(Long aLong) {
        return null;
    }

    @Override
    public ClienteDto getById(Long aLong) {
        Optional<Cliente> cliente = this.clienteRepository.findById(aLong);
        return cliente.map(dtoMapper).orElseThrow();
    }

    @Override
    public List<ClienteDto> getAll() {
        List<Cliente> clientes = this.clienteRepository.findAll();
        return clientes.stream().map(dtoMapper).toList();
    }
}
