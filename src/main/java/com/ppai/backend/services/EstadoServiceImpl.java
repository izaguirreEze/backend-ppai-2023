package com.ppai.backend.services;

import com.ppai.backend.entities.Estado;
import com.ppai.backend.entities.dto.EstadoDto;
import com.ppai.backend.repositories.EstadoRepository;
import com.ppai.backend.services.mappers.EstadoDtoMapper;
import com.ppai.backend.services.mappers.EstadoEntityMapper;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class EstadoServiceImpl implements EstadoService{
    private final EstadoRepository estadoRepository;
    private final EstadoEntityMapper entityMapper;
    private final EstadoDtoMapper dtoMapper;

    public EstadoServiceImpl(EstadoRepository estadoRepository,
                             EstadoEntityMapper entityMapper,
                             EstadoDtoMapper dtoMapper) {
        this.estadoRepository = estadoRepository;
        this.entityMapper = entityMapper;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public EstadoDto add(EstadoDto entity) {
        if (entity == null) throw new InvalidParameterException();
        Optional<Estado> estado = Stream.of(entity).map(entityMapper).findFirst();
        System.out.println(entity);
        System.out.println(estado);
        estado.ifPresent(this.estadoRepository::save);
        return estado.map(dtoMapper).orElseThrow();
    }

    @Override
    public EstadoDto update(EstadoDto entity) {
        return null;
    }

    @Override
    public EstadoDto delete(Long id) {
        return null;
    }


    @Override
    public EstadoDto getById(Long id) {
        Optional<Estado> estado = this.estadoRepository.findById(id);
        return estado.map(dtoMapper).orElseThrow();
    }

    @Override
    public List<EstadoDto> getAll() {
        List<Estado> estados = this.estadoRepository.findAll();
        return estados.stream().map(dtoMapper).toList();
    }
}
