package com.ppai.backend.controllers;

import com.ppai.backend.entities.dto.CambioEstadoDto;
import com.ppai.backend.services.CambioEstadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cambio-estado")
public class CambioEstadoController {
    private final CambioEstadoService cambioEstadoService;

    public CambioEstadoController(CambioEstadoService cambioEstadoService) {
        this.cambioEstadoService = cambioEstadoService;
    }

    @GetMapping
    public ResponseEntity<List<CambioEstadoDto>> getAll(){
        try {
            List<CambioEstadoDto> cambios = this.cambioEstadoService.getAll();
            return ResponseEntity.ok(cambios);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<CambioEstadoDto> add(@RequestBody CambioEstadoDto cambioEstadoDto) {
        try {
            CambioEstadoDto createdCambioEstado = this.cambioEstadoService.add(cambioEstadoDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCambioEstado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
