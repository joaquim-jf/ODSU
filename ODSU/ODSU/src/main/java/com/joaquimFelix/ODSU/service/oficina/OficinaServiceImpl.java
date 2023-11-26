package com.joaquimFelix.ODSU.service.oficina;


import com.joaquimFelix.ODSU.model.entity.Oficina;
import com.joaquimFelix.ODSU.repository.oficina.OficinaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OficinaServiceImpl implements OficinaService {

    private final OficinaRepository oficinaRepository;

    @Autowired
    public OficinaServiceImpl(OficinaRepository oficinaRepository) {
        this.oficinaRepository = oficinaRepository;
    }

    @Override
    public List<Oficina> listarOficina() {
        try {
        return oficinaRepository.findAll();
        } catch (Exception e) {
            // Trate a exceção aqui
            throw new RuntimeException("Erro ao listar oficinas", e);
        }
    }

    @Override
    public Oficina obterOficinaPorId(Long id) {
        return oficinaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Oficina não encontrada com o ID: " + id));
    }

    @Override
    public Oficina cadastrarOficina(Oficina oficina) {
        return oficinaRepository.save(oficina);
    }

    @Override
    public Oficina atualizarOficina(Long id, Oficina oficina) {
        Optional<Oficina> oficinaExistente = oficinaRepository.findById(id);
        if (oficinaExistente.isPresent()) {
            Oficina oficinaAtualizada = oficinaExistente.get();
            oficinaAtualizada.setCarros(oficina.getCarros());
            oficinaAtualizada.setEndereco(oficina.getEndereco());
            oficinaAtualizada.setNome(oficina.getNome());
            oficinaAtualizada.setTelefone(oficina.getTelefone());
            oficinaAtualizada.setCep(oficina.getCep());
            oficinaAtualizada.setClientes(oficina.getClientes());
            oficinaAtualizada.setCnpj(oficina.getCnpj());
            return oficinaRepository.save(oficinaAtualizada);
        } else {
            throw new EntityNotFoundException("Oficina não encontrada");
        }
    }

    @Override
    public void excluirOficina(Long id) {
        // Verifica se a oficina existe antes de tentar excluí-la
        if (!oficinaRepository.existsById(id)) {
            throw new EntityNotFoundException("Oficina não encontrada");
        }
        // Se a oficina existe, então exclui
        oficinaRepository.deleteById(id);
    }
}
