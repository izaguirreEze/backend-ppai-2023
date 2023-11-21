package com.ppai.backend.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidacionDto {
    private long idValidacion;
    private String nombre;
    private long idSubOpcionLlamada;
    private long idOpcionLlamada;
    private long idCategoriaLlamada;
}
