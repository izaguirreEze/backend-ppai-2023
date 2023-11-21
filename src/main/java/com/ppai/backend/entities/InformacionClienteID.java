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
public class InformacionClienteID implements Serializable {
    @Column(name = "id_info_cliente")
    private long idInformacionCliente;
    @Column(name = "id_cliente")
    private long idCliente;
}
