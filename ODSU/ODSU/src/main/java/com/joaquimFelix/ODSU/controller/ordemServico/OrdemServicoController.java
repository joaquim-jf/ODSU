package com.joaquimFelix.ODSU.controller.ordemServico;

import com.joaquimFelix.ODSU.model.entity.carro.Carro;
import com.joaquimFelix.ODSU.model.entity.servico.OrdemServico;
import com.joaquimFelix.ODSU.service.carro.CarroService;
import com.joaquimFelix.ODSU.service.servico.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordensServico")
public class OrdemServicoController {
    private final OrdemServicoService ordemServicoService;
    private final CarroService carroService;

    @Autowired
    public OrdemServicoController(OrdemServicoService ordemServicoService,CarroService carroService) {
        this.ordemServicoService = ordemServicoService;
        this.carroService = carroService;
    }

    @GetMapping
    public List<OrdemServico> listarOrdensServico() {
        return ordemServicoService.listarOrdemServico();
    }

    @GetMapping("/{id}")
    public OrdemServico obterOrdemServicoPorId(@PathVariable Long id) {
        return ordemServicoService.obterOrdemServicoPorId(id);
    }

    @PostMapping //ordensServico?carroId=1
    public ResponseEntity<String> cadastrarCarro(@RequestBody OrdemServico ordemServico, @RequestParam Long carroId) {
        Carro carro = carroService.obterCarroPorId(carroId);
        if (carro == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("carro não encontrado.");
        }
        ordemServico.setCarro(carro);
        ordemServicoService.cadastrarOrdemServico(ordemServico,carroId);
        return ResponseEntity.ok("Ordem serviço cadastrado com sucesso!");
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
