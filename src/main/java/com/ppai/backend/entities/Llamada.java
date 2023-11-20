package com.ppai.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Llamadas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Llamada {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name  = "duracion")
    private long duracion;

    @Column(name = "descripcion_operador")
    private String descripcionOperador;

    @Column(name = "detalle_accion_requerida")
    private String detalleAccionRequerida;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "nro_documento")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "estado_actual", referencedColumnName = "id_estado")
    private Estado estadoActual;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "opcion_seleccionada", referencedColumnName = "id_opcion_llamada", insertable=false, updatable=false),
            @JoinColumn(name = "id_categoria_llamada", referencedColumnName = "id_categoria_llamada", insertable=false, updatable=false)
    })
    private OpcionLlamada opcionSeleccionada;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "sub_opcion_seleccionada", referencedColumnName = "id_sub_opcion_llamada", insertable=false, updatable=false),
            @JoinColumn(name = "opcion_seleccionada", referencedColumnName = "id_opcion_llamada", insertable=false, updatable=false),
            @JoinColumn(name = "id_categoria_llamada", referencedColumnName = "id_categoria_llamada", insertable=false, updatable=false)
    })
    private SubOpcionLlamada subOpcionSeleccionada;

    @ManyToOne
    @JoinColumn(name = "id_categoria_llamada")
    private CategoriaLlamada categoriaLlamada;

    @OneToMany(mappedBy = "llamada")
    private List<CambioEstado> cambioEstados;
}
