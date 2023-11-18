package com.ppai.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "cambios_estado")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CambioEstado {
    @Id
    @Column(name = "fecha_hora_inicio", nullable = false, unique = true)
    private LocalDateTime fechaHoraInicio;

    @ManyToOne
    @JoinColumn(name = "estado_id", nullable = false)
    private Estado estado;
}
