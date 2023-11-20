package com.ppai.backend.services;

import com.ppai.backend.entities.CategoriaLlamada;
import com.ppai.backend.entities.Validacion;
import com.ppai.backend.entities.dto.CategoriaLlamadaDto;
import com.ppai.backend.repositories.CategoriaLlamadaRepository;
import com.ppai.backend.services.mappers.CategoriaDtoMapper;
import com.ppai.backend.services.mappers.CategoriaEntityMapper;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.stream.Stream;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaLlamadaRepository categoriaLlamadaRepository;
    private final CategoriaDtoMapper dtoMapper;
    private final CategoriaEntityMapper entityMapper;

    public CategoriaServiceImpl(CategoriaLlamadaRepository categoriaLlamadaRepository, CategoriaDtoMapper dtoMapper, CategoriaEntityMapper entityMapper) {
        this.categoriaLlamadaRepository = categoriaLlamadaRepository;
        this.dtoMapper = dtoMapper;
        this.entityMapper = entityMapper;
    }

    @Override
    public CategoriaLlamadaDto add(CategoriaLlamadaDto entity) {
            if (entity == null)
                throw new InvalidParameterException();

            Optional<CategoriaLlamada> categEntity = Stream.of(entity).map(entityMapper).findFirst();

            categEntity.ifPresent(this.categoriaLlamadaRepository::save);

            return categEntity.map(dtoMapper).orElseThrow();
    }

    @Override
    public CategoriaLlamadaDto update(CategoriaLlamadaDto entity) {
        return null;
    }

    @Override
    public CategoriaLlamadaDto delete(Long aLong) {
        return null;
    }

    @Override
    public CategoriaLlamadaDto getById(Long aLong) {
        Optional<CategoriaLlamada> categoriaLlamada = this.categoriaLlamadaRepository.findById(aLong);
        return categoriaLlamada.map(dtoMapper).orElseThrow();
    }

    @Override
    public List<CategoriaLlamadaDto> getAll() {
        List<CategoriaLlamada> categoriaLlamadas = this.categoriaLlamadaRepository.findAll();
        return categoriaLlamadas.stream().map(dtoMapper).toList();
    }
}
