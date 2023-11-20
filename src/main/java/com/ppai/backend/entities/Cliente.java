package com.ppai.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @Column(name = "nro_documento", nullable = false, unique = true)
    private long nroDocumento;
    
    @Column(name = "nombre_completo")
    private String nombreCompleto;

    @OneToMany(mappedBy = "cliente")
    private List<InformacionCliente> informacion;

    @OneToMany(mappedBy = "cliente")
    private List<Llamada> llamadas;
}
