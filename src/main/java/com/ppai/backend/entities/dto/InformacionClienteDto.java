package com.ppai.backend.entities.dto;

import com.ppai.backend.entities.InformacionClienteID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InformacionClienteDto {
    private InformacionClienteID idInformacionCliente;
    private long idValidacion;
    private String datoAValidar;
}
