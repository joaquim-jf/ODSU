package com.joaquimFelix.ODSU.service.oficina;

import com.joaquimFelix.ODSU.model.entity.Oficina;

import java.util.List;

public interface OficinaService {
    Oficina obterOficinaPorId(Long id);

    Oficina cadastrarOficina(Oficina oficina);

    Oficina atualizarOficina(Long id, Oficina oficina);

    void excluirOficina(Long id);

    List<Oficina> listarOficina();
}
