package com.joaquimFelix.ODSU.service.carro;

import com.joaquimFelix.ODSU.model.entity.carro.Carro;
import com.joaquimFelix.ODSU.repository.carro.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroServiceImpl implements CarroService{
    private final CarroRepository carroRepository;
    @Autowired
    public CarroServiceImpl(CarroRepository carroRepository){
        this.carroRepository = carroRepository;
    }
    @Override
    public List<Carro> listarCarros(){
        return carroRepository.findAll();
    }
    @Override
    public Carro obterCarroPorId(Long id){
        return carroRepository.findById(id).orElse(null);
    }
    @Override
    public Carro cadastrarCarro(Carro carro){
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
            return null;
        }
    }
    @Override
    public void excluirCarro(Long id){
        carroRepository.deleteById(id);
    }

}
