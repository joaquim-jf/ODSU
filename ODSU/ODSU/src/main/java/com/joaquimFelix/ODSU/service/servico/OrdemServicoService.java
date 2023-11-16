package com.joaquimFelix.ODSU.service.servico;

import com.joaquimFelix.ODSU.model.entity.servico.OrdemServico;

import java.util.List;

public interface OrdemServicoService {
    OrdemServico obterOrdemServicoPorId(Long id);

    OrdemServico cadastrarOrdemServico(OrdemServico ordemServico);

    OrdemServico atualizarOrdemServico(Long id, OrdemServico ordemServico);

    void excluirOrdemServico(Long id);

    List<OrdemServico> listarOrdemServico();
}
