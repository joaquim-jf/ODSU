package com.joaquimFelix.ODSU.controller.ordemServico;

import com.joaquimFelix.ODSU.model.entity.servico.OrdemServico;
import com.joaquimFelix.ODSU.service.servico.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordensServico")
public class OrdemServicoController {
    private final OrdemServicoService ordemServicoService;

    @Autowired
    public OrdemServicoController(OrdemServicoService ordemServicoService) {
        this.ordemServicoService = ordemServicoService;
    }

    @GetMapping
    public List<OrdemServico> listarOrdensServico() {
        return ordemServicoService.listarOrdemServico();
    }

    @GetMapping("/{id}")
    public OrdemServico obterOrdemServicoPorId(@PathVariable Long id) {
        return ordemServicoService.obterOrdemServicoPorId(id);
    }

    @PostMapping
    public OrdemServico cadastrarOrdemServico(@RequestBody OrdemServico ordemServico) {
        return ordemServicoService.cadastrarOrdemServico(ordemServico);
    }

    @PutMapping("/{id}")
    public OrdemServico atualizarOrdemServico(@PathVariable Long id, @RequestBody OrdemServico ordemServico) {
        return ordemServicoService.atualizarOrdemServico(id, ordemServico);
    }

    @DeleteMapping("/{id}")
    public void excluirOrdemServico(@PathVariable Long id) {
        ordemServicoService.excluirOrdemServico(id);
    }
}
