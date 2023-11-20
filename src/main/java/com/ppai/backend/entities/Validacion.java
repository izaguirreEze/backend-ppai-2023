package com.ppai.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Validaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Validacion {
    @Id
    @Column(name = "id_validacion", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idValidacion;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "sub_opcion_llamada", referencedColumnName = "id_sub_opcion_llamada"),
            @JoinColumn(name = "id_opcion_llamada", referencedColumnName = "id_opcion_llamada"),
            @JoinColumn(name = "id_categoria_llamada", referencedColumnName = "id_categoria_llamada")
    })
    private SubOpcionLlamada subOpcion;
}
