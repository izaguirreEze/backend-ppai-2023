package com.ppai.backend.services.mappers;

import com.ppai.backend.entities.Llamada;
import com.ppai.backend.entities.dto.LlamadaDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class LlamadaDtoMapper implements Function<Llamada, LlamadaDto> {
    @Override
    public LlamadaDto apply(Llamada llamada) {
        return new LlamadaDto(
                llamada.getId(),
                llamada.getDescripcionOperador(),
                llamada.getDetalleAccionRequerida(),
                llamada.getDuracion(),
                llamada.getCliente().getNroDocumento(),
                llamada.getEstadoActual().getNombre(),
                llamada.getOpcionSeleccionada().getId().getIdOpcionLlamada(),
                llamada.getSubOpcionSeleccionada().getId().getIdSubOpcionLlamada(),
                llamada.getCategoriaLlamada().getIdCategoriaLlamada()
        );
    }
}
