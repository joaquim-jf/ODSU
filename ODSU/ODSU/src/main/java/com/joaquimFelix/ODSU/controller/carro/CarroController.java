package com.joaquimFelix.ODSU.controller.carro;

import com.joaquimFelix.ODSU.model.entity.carro.Carro;
import com.joaquimFelix.ODSU.service.carro.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {
    private final CarroService carroService;
    @Autowired
    public CarroController(CarroService carroService){
        this.carroService = carroService;
    }
    @GetMapping
    public List<Carro> listarCarros(){
        return carroService.listarCarros();
    }
    @GetMapping("/{id}")
    public Carro obterCarroId(@PathVariable Long id){
        return carroService.obterCarroPorId(id);
    }
    @PostMapping
    public Carro cadastrarCarro(@RequestBody Carro carro) {
        return carroService.cadastrarCarro(carro);
    }
    @PutMapping("/{id}")
    public Carro atualizarCarro(@PathVariable Long id, @RequestBody Carro carro) {
        return carroService.atualizarCarro(id, carro);
    }
    @DeleteMapping("/{id}")
    public void excluirCarro(@PathVariable Long id) {
        carroService.excluirCarro(id);
    }
}
