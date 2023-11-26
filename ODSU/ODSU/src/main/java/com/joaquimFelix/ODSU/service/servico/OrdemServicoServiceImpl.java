package com.joaquimFelix.ODSU.service.servico;

import com.joaquimFelix.ODSU.model.entity.carro.Carro;
import com.joaquimFelix.ODSU.model.entity.servico.OrdemServico;
import com.joaquimFelix.ODSU.repository.servico.OrdemServicoRepository;
import com.joaquimFelix.ODSU.service.carro.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdemServicoServiceImpl implements OrdemServicoService {

    private final OrdemServicoRepository ordemServicoRepository;
    private final CarroService carroService;
    @Autowired
    public OrdemServicoServiceImpl(OrdemServicoRepository ordemServicoRepository, CarroService carroService) {
        this.ordemServicoRepository = ordemServicoRepository;
        this.carroService = carroService;
    }

    @Override
    public List<OrdemServico> listarOrdemServico() {
        return ordemServicoRepository.findAll();
    }

    @Override
    public OrdemServico obterOrdemServicoPorId(Long id) {
        return ordemServicoRepository.findById(id).orElse(null);
    }

    @Override
    public OrdemServico cadastrarOrdemServico(OrdemServico ordemServico, Long carroId) {
        Carro carro = carroService.obterCarroPorId(carroId);
        return ordemServicoRepository.save(ordemServico);
    }

    @Override
    public OrdemServico atualizarOrdemServico(Long id, OrdemServico ordemServico) {
        Optional<OrdemServico> ordemServicoExistente = ordemServicoRepository.findById(id);
        if (ordemServicoExistente.isPresent()) {
            OrdemServico ordemServicoAtualizada = ordemServicoExistente.get();
            ordemServicoAtualizada.setCarro(ordemServico.getCarro());
            ordemServicoAtualizada.setCeramicPro9(ordemServico.isCeramicPro9());
            ordemServicoAtualizada.setDescricao(ordemServico.getDescricao());
            ordemServicoAtualizada.setDescontaminacao(ordemServico.isDescontaminacao());
            ordemServicoAtualizada.setCeramicProLight(ordemServico.isCeramicProLight());
            ordemServicoAtualizada.setDataDeChegada(ordemServico.getDataDeChegada());
            ordemServicoAtualizada.setEnceramento(ordemServico.isEnceramento());
            ordemServicoAtualizada.setFunilaria(ordemServico.isFunilaria());
            ordemServicoAtualizada.setHigienizacaoExterna(ordemServico.isHigienizacaoExterna());
            ordemServicoAtualizada.setHigienizacaoInterna(ordemServico.isHigienizacaoInterna());
            ordemServicoAtualizada.setLavagemMotor(ordemServico.isLavagemMotor());
            ordemServicoAtualizada.setLavagemPremium(ordemServico.isLavagemPremium());
            ordemServicoAtualizada.setLavagemTecnica(ordemServico.isLavagemTecnica());
            ordemServicoAtualizada.setOrcamentoFinal(ordemServico.getOrcamentoFinal());
            ordemServicoAtualizada.setPolimento(ordemServico.isPolimento());
            ordemServicoAtualizada.setReformarRodas(ordemServico.isReformarRodas());
            ordemServicoAtualizada.setRemocaoChuvaAcida(ordemServico.isRemocaoChuvaAcida());
            ordemServicoAtualizada.setRemocaoIsufilme(ordemServico.isRemocaoIsufilme());
            ordemServicoAtualizada.setRevitalizacao(ordemServico.isRevitalizacao());

            return ordemServicoRepository.save(ordemServicoAtualizada);
        } else {
            return null;
        }
    }

    @Override
    public void excluirOrdemServico(Long id) {
        ordemServicoRepository.deleteById(id);
    }
}
