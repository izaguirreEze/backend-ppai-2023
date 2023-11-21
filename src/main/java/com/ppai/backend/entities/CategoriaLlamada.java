package com.ppai.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Categorias_Llamadas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaLlamada {
    @Id
    @Column(name = "id_categoria_llamada", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCategoriaLlamada;

    @Basic
    private String nombre;

    @OneToMany(mappedBy = "categoriaLlamada")
    private List<OpcionLlamada> opciones;

    @OneToMany(mappedBy = "categoriaLlamada")
    private List<SubOpcionLlamada> subopciones;
}
