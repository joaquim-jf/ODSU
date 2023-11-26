package com.joaquimFelix.ODSU.service.carro;

import com.joaquimFelix.ODSU.model.entity.Oficina;
import com.joaquimFelix.ODSU.model.entity.carro.Carro;
import com.joaquimFelix.ODSU.model.entity.cliente.Cliente;
import com.joaquimFelix.ODSU.repository.carro.CarroRepository;
import com.joaquimFelix.ODSU.service.cliente.ClienteService;
import com.joaquimFelix.ODSU.service.oficina.OficinaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroServiceImpl implements CarroService{
    private final CarroRepository carroRepository;
    private final OficinaService oficinaService;
    private final ClienteService clienteService;

    @Autowired
    public CarroServiceImpl(CarroRepository carroRepository, OficinaService oficinaService, ClienteService
                            clienteService){
        this.carroRepository = carroRepository;
        this.oficinaService = oficinaService;
        this.clienteService = clienteService;
    }
    @Override
    public List<Carro> listarCarros(){
        return carroRepository.findAll();
    }
    @Override
    public Carro obterCarroPorId(Long id){
        return carroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Carro não encontrado com o ID: " + id));
    }
    public Carro cadastrarCarro(Carro carro, Long oficinaId, Long clienteId) {
        // Obtém a Oficina com base no ID fornecido
        Oficina oficina = oficinaService.obterOficinaPorId(oficinaId);
        // Configura a Oficina para o Carro
        carro.setOficina(oficina);
        // Obtém o Cliente com base no ID fornecido
        Cliente cliente = clienteService.obterClientePorId(clienteId);
        // Configura o Cliente para o Carro
        carro.setCliente(cliente);
        // Salva o Carro no banco de dados
        return carroRepository.save(carro);
    }
    @Override
    public Carro atualizarCarro(Long id,Carro carro){
        Optional<Carro> carroExistente = carroRepository.findById(id);
        if (carroExistente.isPresent()) {
            Carro carroAtualizado = carroExistente.get();
            carroAtualizado.setPlaca(carro.getPlaca());
            carroAtualizado.setAnoFab(carro.getAnoFab());
            carroAtualizado.setModelo(carro.getModelo());
            carroAtualizado.setChassi(carro.getChassi());
            carroAtualizado.setOrdemServicos(carro.getOrdemServicos());
            carroAtualizado.setCor(carro.getCor());
            return carroRepository.save(carroAtualizado);
        }else{
            throw new EntityNotFoundException("Carro não encontrado com o ID: " + id);
        }
    }
    @Override
    public void excluirCarro(Long id){
        carroRepository.deleteById(id);
    }

}
