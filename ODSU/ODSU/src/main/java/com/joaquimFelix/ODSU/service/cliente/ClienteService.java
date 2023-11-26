package com.joaquimFelix.ODSU.service.cliente;

import com.joaquimFelix.ODSU.model.entity.cliente.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente obterClientePorId(Long id);

    Cliente cadastrarCliente( Cliente cliente,Long oficinaId);

    Cliente atualizarCliente(Long id, Cliente cliente);

    void excluirCliente(Long id);

    List<Cliente> listarClientes();
}
