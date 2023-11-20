package com.ppai.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CambioEstadoID implements Serializable {
    @Column(name = "id_estado")
    private long idEstado;
    @Column(name = "id_llamada")
    private long idLlamada;
    @Column(name = "id_cambio_estado")
    private long idCambioEstado;
}
