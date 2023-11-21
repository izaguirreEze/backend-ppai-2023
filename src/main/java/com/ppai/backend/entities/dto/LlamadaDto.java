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
    private Long duracion;
    private Long idCliente;
    private String estado;
    private Long idOpcionSeleccionada;
    private Long idSubOpcionSeleccionada;
    private Long idCategoria;

    public LlamadaDto(long id, Long idCliente, String estado){
        this.id = id;
        this.idCliente = idCliente;
        this.estado = estado;
    };
}
