package com.ppai.backend.services;

import com.ppai.backend.entities.*;
import com.ppai.backend.entities.dto.SubOpcionLlamadaDto;
import com.ppai.backend.repositories.CategoriaLlamadaRepository;
import com.ppai.backend.repositories.OpcionLlamadaRepository;
import com.ppai.backend.repositories.SubOpcionLlamadaIDGRepository;
import com.ppai.backend.repositories.SubOpcionLlamadaRepository;
import com.ppai.backend.services.mappers.SubOpcionDtoMapper;
import com.ppai.backend.services.mappers.SubOpcionEntityMapper;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class SubOpcionLlamadaServiceImpl implements SubOpcionLlamadaService {
    private final SubOpcionLlamadaRepository subOpcionLlamadaRepository;
    private final SubOpcionLlamadaIDGRepository subOpcionLlamadaIDGRepository;
    private final OpcionLlamadaRepository opcionLlamadaRepository;
    private final CategoriaLlamadaRepository categoriaLlamadaRepository;
    private final SubOpcionDtoMapper dtoMapper;
    private final SubOpcionEntityMapper entityMapper;

    public SubOpcionLlamadaServiceImpl(SubOpcionLlamadaRepository subOpcionLlamadaRepository, SubOpcionLlamadaIDGRepository subOpcionLlamadaIDGRepository, OpcionLlamadaRepository opcionLlamadaRepository, CategoriaLlamadaRepository categoriaLlamadaRepository, SubOpcionDtoMapper dtoMapper, SubOpcionEntityMapper entityMapper) {
        this.subOpcionLlamadaRepository = subOpcionLlamadaRepository;
        this.subOpcionLlamadaIDGRepository = subOpcionLlamadaIDGRepository;
        this.opcionLlamadaRepository = opcionLlamadaRepository;
        this.categoriaLlamadaRepository = categoriaLlamadaRepository;
        this.dtoMapper = dtoMapper;
        this.entityMapper = entityMapper;
    }

    @Override
    public SubOpcionLlamadaDto add(SubOpcionLlamadaDto entity) {
        if (entity == null)
            throw new InvalidParameterException();
        Optional<SubOpcionLlamada> optionalSubOpcionLlamada = Stream.of(entity).map(entityMapper).findFirst();
        if(optionalSubOpcionLlamada.isPresent()){
            SubOpcionLlamada subOpcionLlamada = optionalSubOpcionLlamada.get();
            // MANEJO DE LA ID DE MIERDA
            long id = this.getUltimoNumero();
            subOpcionLlamada.getId().setIdSubOpcionLlamada(id);

            // MANEJO DEL RESTO DE PUNTEROS Y CUESTIONES
            OpcionLlamadaID opID = new OpcionLlamadaID(
                    entity.getId().getIdOpcionLlamada(),
                    entity.getId().getIdCategoriaLlamada()
            );
            Optional<OpcionLlamada> opcionLlamadaOptional = this.opcionLlamadaRepository.findById(opID);
            OpcionLlamada opcionLlamada = opcionLlamadaOptional.orElseThrow();

            Optional<CategoriaLlamada> categoriaLlamadaOptional = this.categoriaLlamadaRepository.findById(entity.getId().getIdCategoriaLlamada());
            CategoriaLlamada categoriaLlamada = categoriaLlamadaOptional.orElseThrow();

            //SETEAR A NUEVO
            subOpcionLlamada.setOpcionLlamada(opcionLlamada);
            subOpcionLlamada.setCategoriaLlamada(categoriaLlamada);
            this.subOpcionLlamadaRepository.save(subOpcionLlamada);
            return this.dtoMapper.apply(subOpcionLlamada);
        }
        else{
            throw new InvalidParameterException();
        }
    }

    @Override
    public SubOpcionLlamadaDto update(SubOpcionLlamadaDto entity) {
        return null;
    }

    @Override
    public SubOpcionLlamadaDto delete(SubOpcionLlamadaID subOpcionLlamadaID) {
        return null;
    }

    @Override
    public SubOpcionLlamadaDto getById(SubOpcionLlamadaID subOpcionLlamadaID) {
        Optional<SubOpcionLlamada> subOpcionLlamada = this.subOpcionLlamadaRepository.findById(subOpcionLlamadaID);
        return subOpcionLlamada.map(dtoMapper).orElseThrow();
    }

    @Override
    public List<SubOpcionLlamadaDto> getAll() {
        List<SubOpcionLlamada> subOpcionLlamadas = this.subOpcionLlamadaRepository.findAll();
        return subOpcionLlamadas.stream().map(dtoMapper).toList();
    }

    public long getUltimoNumero(){
        List<SubOpcionLlamadaIDGenerator> idg = this.subOpcionLlamadaIDGRepository.findAll();
        SubOpcionLlamadaIDGenerator idg1 = new SubOpcionLlamadaIDGenerator();
        if((idg.toArray().length) > 0) {
            idg1 = idg.get((idg.toArray().length) - 1);
        }
        SubOpcionLlamadaIDGenerator idgN = new SubOpcionLlamadaIDGenerator();
        idgN.setNombre("ceID");
        this.subOpcionLlamadaIDGRepository.save(idgN);
        return idg1.getSeq();
    }
}
