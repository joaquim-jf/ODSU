package com.joaquimFelix.ODSU.service.carro;

import com.joaquimFelix.ODSU.model.entity.carro.Carro;

import java.util.List;

public interface CarroService {
    List<Carro> listarCarros();

    Carro obterCarroPorId(Long id);

    Carro cadastrarCarro(Carro carro,Long oficinaId,Long clienteId);

    Carro atualizarCarro(Long id, Carro carro);

    void excluirCarro(Long id);
}
