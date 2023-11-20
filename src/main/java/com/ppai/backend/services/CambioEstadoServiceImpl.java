package com.ppai.backend.services;

import com.ppai.backend.entities.CambioEstado;
import com.ppai.backend.entities.CambioEstadoID;
import com.ppai.backend.entities.CambioEstadoIDGenerator;
import com.ppai.backend.entities.Estado;
import com.ppai.backend.entities.dto.CambioEstadoDto;
import com.ppai.backend.repositories.CambioEstadoIDGRepository;
import com.ppai.backend.repositories.CambioEstadoRepository;
import com.ppai.backend.repositories.EstadoRepository;
import com.ppai.backend.services.mappers.CambioEstadoDtoMapper;
import com.ppai.backend.services.mappers.CambioEstadoEntityMapper;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class CambioEstadoServiceImpl implements CambioEstadoService {

    private final CambioEstadoRepository cambioEstadoRepository;
    private final CambioEstadoIDGRepository cambioEstadoIDGRepository;
    private final EstadoRepository estadoRepository;
    private final CambioEstadoEntityMapper entityMapper;
    private final CambioEstadoDtoMapper dtoMapper;

    public CambioEstadoServiceImpl(CambioEstadoRepository cambioEstadoRepository,
                                   CambioEstadoIDGRepository cambioEstadoIDGRepository,
                                   EstadoRepository estadoRepository,
                                   CambioEstadoEntityMapper entityMapper,
                                   CambioEstadoDtoMapper dtoMapper) {
        this.cambioEstadoRepository = cambioEstadoRepository;
        this.cambioEstadoIDGRepository = cambioEstadoIDGRepository;
        this.estadoRepository = estadoRepository;
        this.entityMapper = entityMapper;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public CambioEstadoDto add(CambioEstadoDto entity) {
        if (entity == null)
            throw new InvalidParameterException();
        Optional<CambioEstado> cambioEstadoOptional = Stream.of(entity).map(entityMapper).findFirst();
        if(cambioEstadoOptional.isPresent()){
            CambioEstado cambioEstado = cambioEstadoOptional.get();
            // MANEJO DE LA ID DE MIERDA
            long idCambioEstado = this.getUltimoNumero();
            cambioEstado.getId().setIdCambioEstado(idCambioEstado);
            Optional <Estado> est = this.estadoRepository.findFirstByNombre(entity.getNombreEstado());
            Estado estado = est.get();
            cambioEstado.setEstado(estado);
            cambioEstado.getId().setIdEstado(estado.getId());
            this.cambioEstadoRepository.save(cambioEstado);
            return this.dtoMapper.apply(cambioEstado);
        }
        else{
            throw new InvalidParameterException();
        }

    }

    @Override
    public CambioEstadoDto update(CambioEstadoDto entity) {
        return null;
    }

    @Override
    public CambioEstadoDto delete(CambioEstadoID cambioEstadoID) {
        return null;
    }

    @Override
    public CambioEstadoDto getById(CambioEstadoID cambioEstadoID) {
        return null;
    }

    @Override
    public List<CambioEstadoDto> getAll() {
        List<CambioEstado> cambiosE = this.cambioEstadoRepository.findAll();
        return cambiosE.stream().map(dtoMapper).toList();
    }
    public long getUltimoNumero(){
        List<CambioEstadoIDGenerator> ceIDG = this.cambioEstadoIDGRepository.findAll();
        CambioEstadoIDGenerator ceIDG1 = new CambioEstadoIDGenerator();
        if((ceIDG.toArray().length) > 0) {
            ceIDG1 = ceIDG.get((ceIDG.toArray().length) - 1);
        }
        CambioEstadoIDGenerator nvCE = new CambioEstadoIDGenerator();
        nvCE.setNombre("ceID");
        this.cambioEstadoIDGRepository.save(nvCE);
        return ceIDG1.getSeq();
    }
}
