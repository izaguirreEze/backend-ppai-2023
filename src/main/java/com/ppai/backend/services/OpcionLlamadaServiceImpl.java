package com.ppai.backend.services;

import com.ppai.backend.entities.*;
import com.ppai.backend.entities.dto.OpcionLlamadaDto;
import com.ppai.backend.repositories.CategoriaLlamadaRepository;
import com.ppai.backend.repositories.OpcionLlamadaIDGRepository;
import com.ppai.backend.repositories.OpcionLlamadaRepository;
import com.ppai.backend.services.mappers.OpcionDtoMapper;
import com.ppai.backend.services.mappers.OpcionEntityMapper;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class OpcionLlamadaServiceImpl implements OpcionLlamadaService {
    private final OpcionLlamadaRepository opcionLlamadaRepository;
    private final OpcionLlamadaIDGRepository opcionLlamadaIDGRepository;
    private final OpcionDtoMapper opcionDtoMapper;
    private final OpcionEntityMapper opcionEntityMapper;
    private final CategoriaLlamadaRepository categoriaLlamadaRepository;

    public OpcionLlamadaServiceImpl(OpcionLlamadaRepository opcionLlamadaRepository, OpcionLlamadaIDGRepository opcionLlamadaIDGRepository, OpcionDtoMapper opcionDtoMapper, OpcionEntityMapper opcionEntityMapper, CategoriaLlamadaRepository categoriaLlamadaRepository) {
        this.opcionLlamadaRepository = opcionLlamadaRepository;
        this.opcionLlamadaIDGRepository = opcionLlamadaIDGRepository;
        this.opcionDtoMapper = opcionDtoMapper;
        this.opcionEntityMapper = opcionEntityMapper;
        this.categoriaLlamadaRepository = categoriaLlamadaRepository;
    }

    @Override
    public OpcionLlamadaDto add(OpcionLlamadaDto entity) {
        if (entity == null)
            throw new InvalidParameterException();
        Optional<OpcionLlamada> opcionLlamadaOptional = Stream.of(entity).map(opcionEntityMapper).findFirst();
        if(opcionLlamadaOptional.isPresent()){
            OpcionLlamada opcionLlamada = opcionLlamadaOptional.get();
            // MANEJO DE LA ID DE MIERDA
            long id = this.getUltimoNumero();
            opcionLlamada.getId().setIdOpcionLlamada(id);

            // MANEJO DEL RESTO DE PUNTEROS Y CUESTIONES
            Optional<CategoriaLlamada> categoriaLlamadaOptional = this.categoriaLlamadaRepository.findById(entity.getId().getIdCategoria());
            CategoriaLlamada categoriaLlamada = categoriaLlamadaOptional.orElseThrow();

            //SETEAR A NUEVO
            opcionLlamada.setCategoriaLlamada(categoriaLlamada);
            this.opcionLlamadaRepository.save(opcionLlamada);
            return this.opcionDtoMapper.apply(opcionLlamada);
        }
        else{
            throw new InvalidParameterException();
        }
    }

    @Override
    public OpcionLlamadaDto update(OpcionLlamadaDto entity) {
        return null;
    }

    @Override
    public OpcionLlamadaDto delete(OpcionLlamadaID opcionLlamadaID) {
        return null;
    }

    @Override
    public OpcionLlamadaDto getById(OpcionLlamadaID opcionLlamadaID) {
        Optional<OpcionLlamada> opcionLlamada = this.opcionLlamadaRepository.findById(opcionLlamadaID);
        return opcionLlamada.map(opcionDtoMapper).orElseThrow();
    }

    @Override
    public List<OpcionLlamadaDto> getAll() {
        List<OpcionLlamada> opcionLlamadas = this.opcionLlamadaRepository.findAll();
        return opcionLlamadas.stream().map(opcionDtoMapper).toList();
    }

    public long getUltimoNumero(){
        List<OpcionLlamadaIDGenerator> idg = this.opcionLlamadaIDGRepository.findAll();
        OpcionLlamadaIDGenerator idg1 = new OpcionLlamadaIDGenerator();
        if((idg.toArray().length) > 0) {
            idg1 = idg.get((idg.toArray().length) - 1);
        }
        OpcionLlamadaIDGenerator idgN = new OpcionLlamadaIDGenerator();
        idgN.setNombre("ceID");
        this.opcionLlamadaIDGRepository.save(idgN);
        return idg1.getSeq();
    }

    @Override
    public List<OpcionLlamadaDto> getAllByIdCategoria(Long idCategoria) {
        Optional<CategoriaLlamada> categoriaLlamadaOptional = this.categoriaLlamadaRepository.findById(idCategoria);
        CategoriaLlamada categoriaLlamada = categoriaLlamadaOptional.orElseThrow();
        List<OpcionLlamada> opcionLlamadas = this.opcionLlamadaRepository.findAllByCategoriaLlamada(categoriaLlamada);
        return opcionLlamadas.stream().map(opcionDtoMapper).toList();
    }
}
