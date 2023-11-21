package com.ppai.backend.services;

import com.ppai.backend.entities.*;
import com.ppai.backend.entities.dto.LlamadaDto;
import com.ppai.backend.repositories.*;
import com.ppai.backend.services.mappers.LlamadaDtoMapper;
import com.ppai.backend.services.mappers.LlamadaEntityMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class LlamadaServiceImpl implements LlamadaService {
    private final LlamadaRepository llamadaRepository;
    private final LlamadaDtoMapper dtoMapper;
    private final LlamadaEntityMapper entityMapper;
    private final OpcionLlamadaRepository opcionLlamadaRepository;
    private final SubOpcionLlamadaRepository subOpcionLlamadaRepository;
    private final CategoriaLlamadaRepository categoriaLlamadaRepository;
    private final ClienteRepository clienteRepository;
    private final EstadoRepository estadoRepository;

    public LlamadaServiceImpl(LlamadaRepository llamadaRepository, LlamadaDtoMapper dtoMapper, LlamadaEntityMapper entityMapper, OpcionLlamadaRepository opcionLlamadaRepository, SubOpcionLlamadaRepository subOpcionLlamadaRepository, CategoriaLlamadaRepository categoriaLlamadaRepository, ClienteRepository clienteRepository, EstadoRepository estadoRepository) {
        this.llamadaRepository = llamadaRepository;
        this.dtoMapper = dtoMapper;
        this.entityMapper = entityMapper;
        this.opcionLlamadaRepository = opcionLlamadaRepository;
        this.subOpcionLlamadaRepository = subOpcionLlamadaRepository;
        this.categoriaLlamadaRepository = categoriaLlamadaRepository;
        this.clienteRepository = clienteRepository;
        this.estadoRepository = estadoRepository;
    }

    @Override
    public LlamadaDto add(LlamadaDto entity) {
        if (entity == null)    throw new NullPointerException("Entity cannot be null");
        entity.setDuracion(null);
        entity.setDescipcionOperador(null);
        entity.setDetalleAccionRequerida(null);
        Optional<Llamada> llamadaOptional = Stream.of(entity).map(entityMapper).findFirst();
        if(llamadaOptional.isPresent()) {
            Llamada llamada = llamadaOptional.get();

            // MANEJO DE PUNTEROS Y CUESTIONES

            // Optional <Estado> est = this.estadoRepository.findFirstByNombre(entity.getNombreEstado());
            // Estado estado = est.get();
            Optional <Estado> est = this.estadoRepository.findFirstByNombre(entity.getEstado());
            Estado estado = est.orElseThrow(() -> new InvalidParameterException("No se encontró el estado"));


            Optional<Cliente> clienteOptional = this.clienteRepository.findById(entity.getIdCliente());
            Cliente cliente = clienteOptional.orElseThrow();

            // SETTERS Y SAVE
            llamada.setCliente(cliente);
            llamada.setEstadoActual(estado);
            this.llamadaRepository.save(llamada);
            return new LlamadaDto(llamada.getId(), llamada.getCliente().getNroDocumento(), llamada.getEstadoActual().getNombre());
        }else{
            throw new InvalidParameterException();
        }
    }

    @Override
    public LlamadaDto update(LlamadaDto entity) {
        Optional<Llamada> llamadaOptional = Stream.of(entity).map(entityMapper).findFirst();
        if(llamadaOptional.isPresent()) {
            Llamada llamada = llamadaOptional.get();

            // MANEJO DE PUNTEROS Y CUESTIONES
            SubOpcionLlamadaID suboID = new SubOpcionLlamadaID(
                    entity.getIdSubOpcionSeleccionada(),
                    entity.getIdOpcionSeleccionada(),
                    entity.getIdCategoria()
            );
            Optional<SubOpcionLlamada> subOpcionLlamadaOptional = this.subOpcionLlamadaRepository.findById(suboID);
            SubOpcionLlamada subOpcionLlamada = subOpcionLlamadaOptional.orElseThrow();

            OpcionLlamadaID opID = new OpcionLlamadaID(
                    entity.getIdOpcionSeleccionada(),
                    entity.getIdCategoria()
            );
            Optional<OpcionLlamada> opcionLlamadaOptional = this.opcionLlamadaRepository.findById(opID);
            OpcionLlamada opcionLlamada = opcionLlamadaOptional.orElseThrow();

            Optional<CategoriaLlamada> categoriaLlamadaOptional = this.categoriaLlamadaRepository.findById(entity.getIdCategoria());
            CategoriaLlamada categoriaLlamada = categoriaLlamadaOptional.orElseThrow();

            Optional<Estado> estadoOptional = this.estadoRepository.findFirstByNombre(entity.getEstado());
            Estado estado = estadoOptional.orElseThrow();

            Optional<Cliente> clienteOptional = this.clienteRepository.findById(entity.getIdCliente());
            Cliente cliente = clienteOptional.orElseThrow();

            // SETTERS Y SAVE
            llamada.setCategoriaLlamada(categoriaLlamada.getIdCategoriaLlamada());
            llamada.setCliente(cliente);
            llamada.setEstadoActual(estado);
            llamada.setOpcionSeleccionada(opcionLlamada.getId().getIdOpcionLlamada());
            llamada.setSubOpcionSeleccionada(subOpcionLlamada.getId().getIdSubOpcionLlamada());
            this.llamadaRepository.save(llamada);
            return this.dtoMapper.apply(llamada);
        }else{
            throw new InvalidParameterException();
        }
    }

    @Override
    public LlamadaDto delete(Long aLong) {
        return null;
    }

    @Override
    public LlamadaDto getById(Long aLong) {
        Optional<Llamada> llamadaOptional = this.llamadaRepository.findById(aLong);
        return llamadaOptional.map(dtoMapper).orElseThrow();
    }

    @Override
    public List<LlamadaDto> getAll() {
        List<Llamada> llamadas = this.llamadaRepository.findAll();
        System.out.println(llamadas.stream().map(dtoMapper).toList());
        return llamadas.stream().map(dtoMapper).toList();
    }
}
