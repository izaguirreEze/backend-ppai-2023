package com.ppai.backend.controllers;

import com.ppai.backend.entities.Llamada;
import com.ppai.backend.entities.dto.ClienteDto;
import com.ppai.backend.entities.dto.LlamadaDto;
import com.ppai.backend.services.ClienteService;
import com.ppai.backend.services.LlamadaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/llamadas")
public class LlamadaController {
    private final LlamadaService llamadaService;

    public LlamadaController(LlamadaService llamadaService) {
        this.llamadaService = llamadaService;
    }

    @GetMapping
    public ResponseEntity<List<LlamadaDto>> getAll(){
        try {
            List<LlamadaDto> llamadaDtos = this.llamadaService.getAll();
            return ResponseEntity.ok(llamadaDtos);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody LlamadaDto llamadaDto){
        try {
            LlamadaDto createdLlamada = this.llamadaService.add(llamadaDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdLlamada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<LlamadaDto> getById(@PathVariable("id") Long id){
        try {
            LlamadaDto llamadaDto = this.llamadaService.getById(id);
            return ResponseEntity.status(HttpStatus.OK).body(llamadaDto);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LlamadaDto> update(@PathVariable long id, @RequestBody LlamadaDto llamadaDto) {
        llamadaDto.setIdLlamada(id);
        LlamadaDto llamadaUpdated = this.llamadaService.update(llamadaDto);
        return ResponseEntity.status(HttpStatus.OK).body(llamadaUpdated);
    }
}
