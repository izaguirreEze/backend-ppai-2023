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
    private Long duracion;

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

    @Column(name = "opcion_seleccionada")
    private Long opcionSeleccionada;

    @Column(name = "sub_opcion_seleccionada")
    private Long subOpcionSeleccionada;

    @Column(name = "id_categoria_llamada")
    private Long categoriaLlamada;

    @OneToMany(mappedBy = "llamada")
    private List<CambioEstado> cambioEstados;
}
