package com.ppai.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Informacion_Clientes_IDGenerator")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InformacionClienteIDGenerator {
    @Id
    @Column(name = "seq", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seq;

    @Column(name = "no_importa")
    private String nombre;
}
