package com.ppai.backend.entities.dto;

import com.ppai.backend.entities.SubOpcionLlamadaID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubOpcionLlamadaDto {
    private SubOpcionLlamadaID idSubOpcionLlamada;
    private String nombre;
}
