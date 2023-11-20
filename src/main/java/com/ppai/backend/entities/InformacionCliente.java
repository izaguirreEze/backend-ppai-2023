package com.ppai.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Informacion_Clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InformacionCliente {
    @EmbeddedId
    private InformacionClienteID id;

    @Column(name = "dato_a_validar")
    private String datoAValidar;

    @ManyToOne
    @MapsId(value = "id_cliente")
    @JoinColumn(name = "id_cliente", referencedColumnName = "nro_documento")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "validacion", referencedColumnName = "id_validacion")
    private Validacion validacion;
}
