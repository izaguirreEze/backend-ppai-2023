package com.ppai.backend.services;

import com.ppai.backend.entities.InformacionCliente;
import com.ppai.backend.entities.InformacionClienteID;
import com.ppai.backend.entities.dto.InformacionClienteDto;

import java.util.List;

public interface InformacionClienteService  extends Service<InformacionClienteDto, InformacionClienteID>{
    public List<InformacionClienteDto> getAllByCliente(Long nroDocumento);
}
