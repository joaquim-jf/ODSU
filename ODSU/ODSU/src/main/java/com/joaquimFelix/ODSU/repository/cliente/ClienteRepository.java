package com.joaquimFelix.ODSU.repository.cliente;

import com.joaquimFelix.ODSU.model.entity.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
