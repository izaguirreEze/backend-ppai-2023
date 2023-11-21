package com.ppai.backend.controllers;

import com.ppai.backend.entities.InformacionClienteID;
import com.ppai.backend.entities.dto.ClienteDto;
import com.ppai.backend.entities.dto.InformacionClienteDto;
import com.ppai.backend.services.ClienteService;
import com.ppai.backend.services.InformacionClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/informacion-clientes")
public class InformacionClienteController {
    private final InformacionClienteService informacionClienteService;

    public InformacionClienteController(InformacionClienteService informacionClienteService) {
        this.informacionClienteService = informacionClienteService;
    }

    @GetMapping
    public ResponseEntity<List<InformacionClienteDto>> getAll(){
        try {
            List<InformacionClienteDto> informacionClientes = this.informacionClienteService.getAll();
            return ResponseEntity.ok(informacionClientes);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<InformacionClienteDto> add(@RequestBody InformacionClienteDto informacionClienteDto){
        try {
            InformacionClienteDto createdInformacionCliente = this.informacionClienteService.add(informacionClienteDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdInformacionCliente);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{info-id}/{cliente-id}")
    public ResponseEntity<InformacionClienteDto> getById(
            @PathVariable("info-id") Long infoCliId,
            @PathVariable("cliente-id") Long clienteId
    ){
        InformacionClienteID infoID = new InformacionClienteID(
                infoCliId,
                clienteId
        );
        try {
            InformacionClienteDto informacionClienteDto = this.informacionClienteService.getById(infoID);
            return ResponseEntity.status(HttpStatus.OK).body(informacionClienteDto);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
