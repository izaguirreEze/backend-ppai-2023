package com.ppai.backend.entities.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadoDto {
    private long idEstado;
    private String nombre;
}
