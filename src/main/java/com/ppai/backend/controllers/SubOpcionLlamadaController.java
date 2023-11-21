package com.ppai.backend.controllers;

import com.ppai.backend.entities.SubOpcionLlamadaID;
import com.ppai.backend.entities.dto.SubOpcionLlamadaDto;
import com.ppai.backend.services.SubOpcionLlamadaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/sub-opciones-llamada")
public class SubOpcionLlamadaController {
    private final SubOpcionLlamadaService subOpcionLlamadaService;

    public SubOpcionLlamadaController(SubOpcionLlamadaService subOpcionLlamadaService) {
        this.subOpcionLlamadaService = subOpcionLlamadaService;
    }

    @GetMapping
    public ResponseEntity<List<SubOpcionLlamadaDto>> getAll(){
        try {
            List<SubOpcionLlamadaDto> subOpcionLlamadaDtos = this.subOpcionLlamadaService.getAll();
            return ResponseEntity.ok(subOpcionLlamadaDtos);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<SubOpcionLlamadaDto> add(@RequestBody SubOpcionLlamadaDto subOpcionLlamadaDto){
        try {
            SubOpcionLlamadaDto createdSubOpcionLlamada = this.subOpcionLlamadaService.add(subOpcionLlamadaDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdSubOpcionLlamada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{sub-opcion-id}/{opcion-id}/{categoria-id}")
    public ResponseEntity<SubOpcionLlamadaDto> getById(
            @PathVariable("sub-opcion-id") Long subOpcionId,
            @PathVariable("opcion-id") Long opcionId,
            @PathVariable("categoria-id") Long cateId
    ){
        SubOpcionLlamadaID subOpID = new SubOpcionLlamadaID(
                subOpcionId,
                opcionId,
                cateId
        );
        try {
            SubOpcionLlamadaDto subOpcionLlamadaDto = this.subOpcionLlamadaService.getById(subOpID);
            return ResponseEntity.status(HttpStatus.OK).body(subOpcionLlamadaDto);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/all-by-opcion")
    public ResponseEntity<List<SubOpcionLlamadaDto>> getAllByIdOpcion(
            @RequestParam(name = "id-opcion") Long idOpcion,
            @RequestParam(name = "id-categoria")Long idCategoria
    ){
        try {
            List<SubOpcionLlamadaDto> subOpcionLlamadaDtos = this.subOpcionLlamadaService.getAllByIdOpcion(idOpcion, idCategoria);
            return ResponseEntity.ok(subOpcionLlamadaDtos);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
