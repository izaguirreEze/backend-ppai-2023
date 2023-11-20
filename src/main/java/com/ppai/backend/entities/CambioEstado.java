package com.ppai.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Cambios_Estados")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CambioEstado {
    @EmbeddedId
    private CambioEstadoID id;
    
    @Column(name = "fecha_hora_inicio", nullable = false, unique = true)
    private LocalDateTime fechaHoraInicio;
    
    @ManyToOne
    @MapsId(value = "id_estado")
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;

    @ManyToOne
    @MapsId(value = "id_llamada")
    @JoinColumn(name = "id_llamada", referencedColumnName = "id")
    private Llamada llamada;
}
