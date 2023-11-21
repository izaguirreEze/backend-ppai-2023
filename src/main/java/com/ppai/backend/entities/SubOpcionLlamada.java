package com.ppai.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Sub_Opciones_Llamadas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubOpcionLlamada {
    @EmbeddedId
    private SubOpcionLlamadaID id;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @MapsId(value = "id_categoria_llamada")
    @JoinColumn(name = "id_categoria_llamada")
    private CategoriaLlamada categoriaLlamada;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id_categoria_llamada", referencedColumnName = "id_categoria_llamada", insertable=false, updatable=false),
            @JoinColumn(name = "id_opcion_llamada", referencedColumnName = "id_opcion_llamada", insertable=false, updatable=false)
    })
    private OpcionLlamada opcionLlamada;

    @OneToMany(mappedBy = "subOpcion")
    private List<Validacion> validaciones;

}
