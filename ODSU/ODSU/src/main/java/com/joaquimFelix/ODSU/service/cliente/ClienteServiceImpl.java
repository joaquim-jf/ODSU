package com.joaquimFelix.ODSU.service.cliente;

import com.joaquimFelix.ODSU.model.entity.cliente.Cliente;
import com.joaquimFelix.ODSU.repository.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClienteServiceImpl implements ClienteService {
  private final ClienteRepository clienteRepository;
  @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository){
      this.clienteRepository = clienteRepository;
  }
  @Override
    public List<Cliente> listarClientes(){
      return clienteRepository.findAll();
  }
    @Override
    public Cliente cadastrarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
  @Override
    public Cliente obterClientePorId(Long id){
      return clienteRepository.findById(id).orElse(null);
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
          return null;
      }
  }
  @Override
  public void excluirCliente(Long id){
      clienteRepository.deleteById(id);
  }
}