package com.ppai.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class SubOpcionLlamadaID implements Serializable{
    @Column(name = "id_sub_opcion_llamada")
    private long idSubOpcionLlamada;
    @Column(name = "id_opcion_llamada")
    private long idOpcionLlamada;
    @Column(name = "id_categoria_llamada")
    private long idCategoriaLlamada;
}
