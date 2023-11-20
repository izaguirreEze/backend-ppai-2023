package com.ppai.backend.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LlamadaDto {
    private long id;
    private String descipcionOperador;
    private String detalleAccionRequerida;
    private long duracion;
    private long idCliente;
    private String estado;
    private long idOpcionSeleccionada;
    private long idSubOpcionSeleccionada;
    private long idCategoria;
}
