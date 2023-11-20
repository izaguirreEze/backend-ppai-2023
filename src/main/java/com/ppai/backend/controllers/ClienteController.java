package com.ppai.backend.controllers;

import com.ppai.backend.entities.dto.CategoriaLlamadaDto;
import com.ppai.backend.entities.dto.ClienteDto;
import com.ppai.backend.services.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDto>> getAll(){
        try {
            List<ClienteDto> clientes = this.clienteService.getAll();
            return ResponseEntity.ok(clientes);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<ClienteDto> add(@RequestBody ClienteDto clienteDto){
        try {
            ClienteDto createdCliente = this.clienteService.add(clienteDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCliente);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> getById(@PathVariable("id") Long id){
        try {
            ClienteDto cliente = this.clienteService.getById(id);
            return ResponseEntity.status(HttpStatus.OK).body(cliente);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
