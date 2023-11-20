package com.ppai.backend.entities.dto;

import com.ppai.backend.entities.CambioEstadoID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CambioEstadoDto {
    private CambioEstadoID id;
    private String nombreEstado;
    private LocalDateTime fechaHoraInicio;
}
