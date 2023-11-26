package com.joaquimFelix.ODSU.controller.carro;

import com.joaquimFelix.ODSU.model.entity.carro.Carro;
import com.joaquimFelix.ODSU.model.entity.cliente.Cliente;
import com.joaquimFelix.ODSU.service.carro.CarroService;
import com.joaquimFelix.ODSU.service.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {
    private final CarroService carroService;
    private final ClienteService clienteService;

    @Autowired
    public CarroController(CarroService carroService, ClienteService clienteService){
        this.carroService = carroService;
        this.clienteService = clienteService;
    }
    @GetMapping
    public List<Carro> listarCarros(){
        return carroService.listarCarros();
    }
    @GetMapping("/{id}")
    public Carro obterCarroId(@PathVariable Long id){
        return carroService.obterCarroPorId(id);
    }
    @PostMapping // exemplo carros?oficinaId=1&clienteId=1
    public ResponseEntity<String>cadastrarCarro( @RequestBody Carro carro, @RequestParam Long oficinaId, @RequestParam Long clienteId) {
        Cliente cliente = clienteService.obterClientePorId(clienteId);
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        // Associar o cliente ao carro
        carro.setCliente(cliente);
        // Salvar o carro
        carroService.cadastrarCarro(carro, oficinaId, clienteId);
        return ResponseEntity.ok("Carro cadastrado com sucesso!");
    }
    @PutMapping("/{id}") // exemplo carros/1
    public Carro atualizarCarro(@PathVariable Long id, @RequestBody Carro carro) {
        return carroService.atualizarCarro(id, carro);
    }
    @DeleteMapping("/{id}")// exemplo carros/1
    public void excluirCarro(@PathVariable Long id) {
        carroService.excluirCarro(id);
    }
}
