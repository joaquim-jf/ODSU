package com.joaquimFelix.ODSU.controller.cliente;

import com.joaquimFelix.ODSU.model.entity.cliente.Cliente;
import com.joaquimFelix.ODSU.service.cliente.ClienteService;
import com.joaquimFelix.ODSU.service.oficina.OficinaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.joaquimFelix.ODSU.model.entity.Oficina;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> obterClientePorId(@PathVariable Long id) {
        try {
            Cliente cliente = clienteService.obterClientePorId(id);
            return ResponseEntity.ok(cliente);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado com o ID: " + id);
        }
    }

    @PostMapping// colocar o id da oficina na url (clientes?oficinaId=123)
    public ResponseEntity<String> cadastrarCliente(@RequestBody Cliente cliente, @RequestParam Long oficinaId) {
            clienteService.cadastrarCliente(cliente, oficinaId);
            return ResponseEntity.ok("Cliente cadastrado com sucesso!");
    }

    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.atualizarCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void excluirCliente(@PathVariable Long id) {
        clienteService.excluirCliente(id);
    }
}