package com.ppai.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Opciones_Llamadas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpcionLlamada {

    @EmbeddedId
    private OpcionLlamadaID id;

    @Basic
    private String nombre;

    @ManyToOne
    @MapsId(value = "id_categoria_llamada")
    @JoinColumn(name = "id_categoria_llamada")
    private CategoriaLlamada categoriaLlamada;

    @OneToMany(mappedBy = "opcionLlamada")
    private List<OpcionLlamada> opcionesLlamada;
}
