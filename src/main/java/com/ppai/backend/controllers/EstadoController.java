package com.ppai.backend.controllers;

import com.ppai.backend.entities.Estado;
import com.ppai.backend.entities.dto.EstadoDto;
import com.ppai.backend.services.EstadoService;
import com.ppai.backend.services.mappers.EstadoDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/estado")
public class EstadoController {
    private final EstadoService serviceE;

    public EstadoController(EstadoService serviceE) {
        this.serviceE = serviceE;
    }

    //@GetMapping
    //    public ResponseEntity<List<CambioEstadoDto>> getAll(){
    //        try {
    //            List<CambioEstadoDto> cambios = this.serviceCE.getAll();
    //            return ResponseEntity.ok(cambios);
    //        }catch (Exception e) {
    //            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    //        }
    //    }
    @GetMapping
    public ResponseEntity<List<EstadoDto>> getAll(){
        try{
            List<EstadoDto> estados = this.serviceE.getAll();
            return ResponseEntity.ok(estados);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<EstadoDto> add(@RequestBody EstadoDto estadoDto){
        try{
            EstadoDto createdEstadoDto = this.serviceE.add(estadoDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdEstadoDto);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}

