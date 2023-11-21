package com.ppai.backend.services.mappers;

import com.ppai.backend.entities.Llamada;
import com.ppai.backend.entities.dto.LlamadaDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class LlamadaDtoMapper implements Function<Llamada, LlamadaDto> {
    @Override
    public LlamadaDto apply(Llamada llamada) {
        Long duracion = null;
        Long opcionSeleccionada = null;
        Long subOpcionSeleccionada = null;
        String descripcionOperador = null;
        String detalleAccionRequerida = null;
        Long categoriaLlamada = null;

        if(llamada.getDescripcionOperador() != null) descripcionOperador = llamada.getDescripcionOperador();
        if(llamada.getDetalleAccionRequerida() != null) detalleAccionRequerida = llamada.getDetalleAccionRequerida();
        if(llamada.getDuracion() != null) duracion = llamada.getDuracion();
        if(llamada.getOpcionSeleccionada() != null) opcionSeleccionada = llamada.getOpcionSeleccionada();
        if(llamada.getSubOpcionSeleccionada() != null) subOpcionSeleccionada = llamada.getSubOpcionSeleccionada();
        if(llamada.getCategoriaLlamada() != null) categoriaLlamada = llamada.getCategoriaLlamada();
        return new LlamadaDto(
                llamada.getId(),
                descripcionOperador,
                detalleAccionRequerida,
                duracion,
                llamada.getCliente().getNroDocumento(),
                llamada.getEstadoActual().getNombre(),
                opcionSeleccionada,
                subOpcionSeleccionada,
                categoriaLlamada
        );
    }
}
