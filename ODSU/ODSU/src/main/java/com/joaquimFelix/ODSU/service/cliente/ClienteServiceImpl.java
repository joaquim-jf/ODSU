package com.joaquimFelix.ODSU.service.cliente;
import com.joaquimFelix.ODSU.model.entity.Oficina;
import com.joaquimFelix.ODSU.model.entity.cliente.Cliente;
import com.joaquimFelix.ODSU.repository.cliente.ClienteRepository;
import com.joaquimFelix.ODSU.service.oficina.OficinaService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {
  private final ClienteRepository clienteRepository;
  private final OficinaService oficinaService;
    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository, OficinaService oficinaService){
      this.clienteRepository = clienteRepository;
        this.oficinaService = oficinaService;
    }

  @Override
    public List<Cliente> listarClientes(){
      return clienteRepository.findAll();
  }

    @Override
    public Cliente cadastrarCliente(Cliente cliente, Long oficinaId) {
        // Obtém a Oficina com base no ID fornecido
        Oficina oficina = oficinaService.obterOficinaPorId(oficinaId);
        // Configura a Oficina para o Cliente
        cliente.setOficina(oficina);
        // Salva o Cliente no banco de dados
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente obterClientePorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + id));
    }
  @Override
  public Cliente atualizarCliente(Long id, Cliente cliente) {
      Optional<Cliente> clienteExistente = clienteRepository.findById(id);
      if (clienteExistente.isPresent()) {
          Cliente clienteAtualizado = clienteExistente.get();
          clienteAtualizado.setCarros(cliente.getCarros());
          clienteAtualizado.setEmail(cliente.getEmail());
          clienteAtualizado.setEndereco(cliente.getEndereco());
          clienteAtualizado.setNome(cliente.getNome());
          clienteAtualizado.setTelefone(cliente.getTelefone());
          return clienteRepository.save(clienteAtualizado);
      } else {
          throw new EntityNotFoundException("Cliente não encontrado com o ID: " + id);
      }
  }
  @Override
  public void excluirCliente(Long id){
      clienteRepository.deleteById(id);
  }
}