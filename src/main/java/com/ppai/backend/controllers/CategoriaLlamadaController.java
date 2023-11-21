package com.ppai.backend.controllers;

import com.ppai.backend.entities.dto.CambioEstadoDto;
import com.ppai.backend.entities.dto.CategoriaLlamadaDto;
import com.ppai.backend.services.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/categorias-llamada")
public class CategoriaLlamadaController {
    private final CategoriaService categoriaService;

    public CategoriaLlamadaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaLlamadaDto>> getAll(){
        try {
            List<CategoriaLlamadaDto> categorias = this.categoriaService.getAll();
            return ResponseEntity.ok(categorias);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<CategoriaLlamadaDto> add(@RequestBody CategoriaLlamadaDto categoriaDto){
        try {
            CategoriaLlamadaDto createdCategoriaLlamada = this.categoriaService.add(categoriaDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCategoriaLlamada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaLlamadaDto> getById(@PathVariable("id") Long id){
        try {
            CategoriaLlamadaDto orderDetail = this.categoriaService.getById(id);
            return ResponseEntity.status(HttpStatus.OK).body(orderDetail);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

