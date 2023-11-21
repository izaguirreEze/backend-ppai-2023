package com.ppai.backend.entities.dto;

import com.ppai.backend.entities.OpcionLlamadaID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpcionLlamadaDto {
    private OpcionLlamadaID idOpcionLlamada;
    private String nombre;
}
