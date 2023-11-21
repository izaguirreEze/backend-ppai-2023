package com.ppai.backend.controllers;

import com.ppai.backend.entities.dto.LlamadaDto;
import com.ppai.backend.entities.dto.ValidacionDto;
import com.ppai.backend.services.ValidacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/validaciones")
public class ValidacionController {
    private final ValidacionService validacionService;

    public ValidacionController(ValidacionService validacionService) {
        this.validacionService = validacionService;
    }

    @GetMapping
    public ResponseEntity<List<ValidacionDto>> getAll(){
        try {
            List<ValidacionDto> validacionDtos = this.validacionService.getAll();
            return ResponseEntity.ok(validacionDtos);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<ValidacionDto> add(@RequestBody ValidacionDto validacionDto){
        try {
            ValidacionDto createdValidacion = this.validacionService.add(validacionDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdValidacion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ValidacionDto> getById(@PathVariable("id") Long id){
        try {
            ValidacionDto validacionDto = this.validacionService.getById(id);
            return ResponseEntity.status(HttpStatus.OK).body(validacionDto);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
