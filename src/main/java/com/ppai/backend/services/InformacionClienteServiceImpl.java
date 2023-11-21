package com.ppai.backend.services;

import com.ppai.backend.entities.*;
import com.ppai.backend.entities.dto.InformacionClienteDto;
import com.ppai.backend.repositories.*;
import com.ppai.backend.services.mappers.InformacionClienteDtoMapper;
import com.ppai.backend.services.mappers.InformacionClienteEntityMapper;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class InformacionClienteServiceImpl implements InformacionClienteService {
    private final InformacionClienteRepository informacionClienteRepository;
    private final InformacionClienteIDGRepository informacionClienteIDGRepository;
    private final InformacionClienteDtoMapper dtoMapper;
    private final InformacionClienteEntityMapper entityMapper;
    private final ClienteRepository clienteRepository;
    private final ValidacionRepository validacionRepository;

    public InformacionClienteServiceImpl(InformacionClienteRepository informacionClienteRepository, InformacionClienteIDGRepository informacionClienteIDGRepository, InformacionClienteDtoMapper informacionClienteDtoMapper, InformacionClienteEntityMapper entityMapper, ClienteRepository clienteRepository, ValidacionRepository validacionRepository) {
        this.informacionClienteRepository = informacionClienteRepository;
        this.informacionClienteIDGRepository = informacionClienteIDGRepository;
        this.dtoMapper = informacionClienteDtoMapper;
        this.entityMapper = entityMapper;
        this.clienteRepository = clienteRepository;
        this.validacionRepository = validacionRepository;
    }

    @Override
    public InformacionClienteDto add(InformacionClienteDto entity) {
        if (entity == null)
            throw new InvalidParameterException();
        Optional<InformacionCliente> informacionClienteOptional = Stream.of(entity).map(entityMapper).findFirst();
        if(informacionClienteOptional.isPresent()){
            InformacionCliente informacionCliente = informacionClienteOptional.get();
            // MANEJO DE LA ID DE MIERDA
            long id = this.getUltimoNumero();
            informacionCliente.getId().setId(id);

            Optional<Cliente> clienteOptional = this.clienteRepository.findById(entity.getId().getIdCliente());
            Cliente cliente = clienteOptional.orElseThrow();

            Optional<Validacion> validacionOptional = this.validacionRepository.findById(entity.getIdValidacion());
            Validacion validacion = validacionOptional.orElseThrow();

            //SETEAR A NUEVO
            informacionCliente.setCliente(cliente);
            informacionCliente.setValidacion(validacion);
            this.informacionClienteRepository.save(informacionCliente);
            return this.dtoMapper.apply(informacionCliente);
        }
        else{
            throw new InvalidParameterException();
        }
    }

    @Override
    public InformacionClienteDto update(InformacionClienteDto entity) {
        return null;
    }

    @Override
    public InformacionClienteDto delete(InformacionClienteID informacionClienteID) {
        return null;
    }

    @Override
    public InformacionClienteDto getById(InformacionClienteID informacionClienteID) {
        Optional<InformacionCliente> informacionCliente = this.informacionClienteRepository.findById(informacionClienteID);
        return informacionCliente.map(dtoMapper).orElseThrow();
    }

    @Override
    public List<InformacionClienteDto> getAll() {
        List<InformacionCliente> informacionClientes = this.informacionClienteRepository.findAll();
        return informacionClientes.stream().map(dtoMapper).toList();
    }

    public long getUltimoNumero(){
        List<InformacionClienteIDGenerator> idg = this.informacionClienteIDGRepository.findAll();
        InformacionClienteIDGenerator idg1 = new InformacionClienteIDGenerator();
        if((idg.toArray().length) > 0) {
            idg1 = idg.get((idg.toArray().length) - 1);
        }
        InformacionClienteIDGenerator idgN = new InformacionClienteIDGenerator();
        idgN.setNombre("ceID");
        this.informacionClienteIDGRepository.save(idgN);
        return idg1.getSeq();
    }

    @Override
    public List<InformacionClienteDto> getAllByCliente(Long nroDocumento) {
        Optional<Cliente> clienteOptional = this.clienteRepository.findById(nroDocumento);
        Cliente cliente = clienteOptional.orElseThrow();

        List<InformacionCliente> informacionClientes = this.informacionClienteRepository.findAllByCliente(cliente);
        return informacionClientes.stream().map(dtoMapper).toList();
    }
}
