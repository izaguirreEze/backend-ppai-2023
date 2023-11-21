package com.ppai.backend.controllers;

import com.ppai.backend.entities.InformacionClienteID;
import com.ppai.backend.entities.OpcionLlamadaID;
import com.ppai.backend.entities.dto.InformacionClienteDto;
import com.ppai.backend.entities.dto.OpcionLlamadaDto;
import com.ppai.backend.services.InformacionClienteService;
import com.ppai.backend.services.OpcionLlamadaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/opciones-llamada")
public class OpcionLlamadaController {
    private final OpcionLlamadaService opcionLlamadaService;

    public OpcionLlamadaController(OpcionLlamadaService opcionLlamadaService) {
        this.opcionLlamadaService = opcionLlamadaService;
    }

    @GetMapping
    public ResponseEntity<List<OpcionLlamadaDto>> getAll(){
        try {
            List<OpcionLlamadaDto> opcionLlamadaDtos = this.opcionLlamadaService.getAll();
            return ResponseEntity.ok(opcionLlamadaDtos);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<OpcionLlamadaDto> add(@RequestBody OpcionLlamadaDto opcionLlamadaDto){
        try {
            OpcionLlamadaDto createdOpcionLlamada = this.opcionLlamadaService.add(opcionLlamadaDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdOpcionLlamada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{opcion-id}/{categoria-id}")
    public ResponseEntity<OpcionLlamadaDto> getById(
            @PathVariable("opcion-id") Long opcionId,
            @PathVariable("categoria-id") Long cateId
    ){
        OpcionLlamadaID opID = new OpcionLlamadaID(
                opcionId,
                cateId
        );
        try {
            OpcionLlamadaDto opcionLlamadaDto = this.opcionLlamadaService.getById(opID);
            return ResponseEntity.status(HttpStatus.OK).body(opcionLlamadaDto);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/all-by-categoria")
    public ResponseEntity<List<OpcionLlamadaDto>> getAllByIdCategoria(
            @RequestParam(name = "id-categoria") Long idCategoria
    ){
        try {
            List<OpcionLlamadaDto> opcionLlamadaDtos = this.opcionLlamadaService.getAllByIdCategoria(idCategoria);
            return ResponseEntity.ok(opcionLlamadaDtos);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
