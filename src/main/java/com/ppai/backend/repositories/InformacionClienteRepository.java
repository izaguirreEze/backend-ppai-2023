package com.ppai.backend.repositories;

import com.ppai.backend.entities.Cliente;
import com.ppai.backend.entities.InformacionCliente;
import com.ppai.backend.entities.InformacionClienteID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InformacionClienteRepository extends JpaRepository<InformacionCliente, InformacionClienteID> {
    List<InformacionCliente> findAllByCliente(Cliente cliente);
}
