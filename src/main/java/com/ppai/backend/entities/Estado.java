package com.ppai.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Estados")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estado {
    @Id
    @Column(name = "id_estado", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Basic
    private String nombre;

    @OneToMany(mappedBy = "estado")
    private List<CambioEstado> cambiosEstado;

    @OneToMany(mappedBy = "estadoActual")
    private List<Llamada> llamadas;
}
