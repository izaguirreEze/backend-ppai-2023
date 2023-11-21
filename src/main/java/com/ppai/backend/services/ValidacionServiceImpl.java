package com.ppai.backend.services;

import com.ppai.backend.entities.SubOpcionLlamada;
import com.ppai.backend.entities.SubOpcionLlamadaID;
import com.ppai.backend.entities.Validacion;
import com.ppai.backend.entities.dto.ValidacionDto;
import com.ppai.backend.repositories.SubOpcionLlamadaRepository;
import com.ppai.backend.repositories.ValidacionRepository;
import com.ppai.backend.services.mappers.ValidacionDtoMapper;
import com.ppai.backend.services.mappers.ValidacionEntityMapper;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ValidacionServiceImpl implements ValidacionService {
    private final ValidacionRepository validacionRepository;
    private final ValidacionDtoMapper dtoMapper;
    private final ValidacionEntityMapper entityMapper;
    private final SubOpcionLlamadaRepository subOpcionLlamadaRepository;

    public ValidacionServiceImpl(ValidacionRepository validacionRepository, ValidacionDtoMapper dtoMapper, ValidacionEntityMapper entityMapper, SubOpcionLlamadaRepository subOpcionLlamadaRepository) {
        this.validacionRepository = validacionRepository;
        this.dtoMapper = dtoMapper;
        this.entityMapper = entityMapper;
        this.subOpcionLlamadaRepository = subOpcionLlamadaRepository;
    }

    @Override
    public ValidacionDto add(ValidacionDto entity) {
        if (entity == null)
            throw new InvalidParameterException();

        Optional<Validacion> validacionEntity = Stream.of(entity).map(entityMapper).findFirst();

        // buscar subo
        SubOpcionLlamadaID suboID = new SubOpcionLlamadaID(
                entity.getIdSubOpcionLlamada(),
                entity.getIdOpcionLlamada(),
                entity.getIdCategoriaLlamada()
        );
        Optional<SubOpcionLlamada> subOpcionLlamadaOptional = this.subOpcionLlamadaRepository.findById(suboID);
        SubOpcionLlamada subOpcionLlamada = subOpcionLlamadaOptional.orElseThrow();

        //setear y save
        validacionEntity.get().setSubOpcion(subOpcionLlamada);
        validacionEntity.ifPresent(this.validacionRepository::save);
        return validacionEntity.map(dtoMapper).orElseThrow();
    }

    @Override
    public ValidacionDto update(ValidacionDto entity) {
        return null;
    }

    @Override
    public ValidacionDto delete(Long aLong) {
        return null;
    }

    @Override
    public ValidacionDto getById(Long aLong) {
        Optional<Validacion> validacion = this.validacionRepository.findById(aLong);
        return validacion.map(dtoMapper).orElseThrow();
    }

    @Override
    public List<ValidacionDto> getAll() {
        List<Validacion> validacions = this.validacionRepository.findAll();
        return validacions.stream().map(dtoMapper).toList();
    }
    @Override
    public List<ValidacionDto> getAllByIdSubOpcion(Long idSubo, Long idOpcion, Long idCategoria){
        SubOpcionLlamadaID suboID = new SubOpcionLlamadaID(
                idSubo,
                idOpcion,
                idCategoria
        );
        Optional<SubOpcionLlamada> subopcionABuscar = this.subOpcionLlamadaRepository.findById(suboID);
        SubOpcionLlamada subOpcionLlamada = subopcionABuscar.orElseThrow();
        List<Validacion> validacions = this.validacionRepository.findAllBySubOpcion(subOpcionLlamada);
        return validacions.stream().map(dtoMapper).toList();
    }
}
