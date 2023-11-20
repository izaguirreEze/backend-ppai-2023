package com.ppai.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="Sub_Opciones_Llamadas_IDGenerator")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubOpcionLlamadaIDGenerator {
    @Id
    @Column(name = "seq", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seq;

    @Column(name = "no_importa")
    private String nombre;
}
