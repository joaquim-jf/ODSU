package com.joaquimFelix.ODSU.controller.oficina;

import com.joaquimFelix.ODSU.model.entity.Oficina;
import com.joaquimFelix.ODSU.service.oficina.OficinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oficinas")
public class OficinaController {
    private final OficinaService oficinaService;

    @Autowired
    public OficinaController(OficinaService oficinaService) {
        this.oficinaService = oficinaService;
    }

    @GetMapping
    public List<Oficina> listarOficinas() {
        return oficinaService.listarOficina();
    }

    @GetMapping("/{id}")
    public Oficina obterOficinaPorId(@PathVariable Long id) {
        return oficinaService.obterOficinaPorId(id);
    }

    @PostMapping
    public ResponseEntity<String> cadastrarOficina(@RequestBody Oficina oficina) {
        try {
            oficinaService.cadastrarOficina(oficina);
            return ResponseEntity.ok("Oficina cadastrada com sucesso!");
        } catch (Exception e) {
            // Trate exceções ou erros de validação aqui
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar oficina.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarOficina(@PathVariable Long id, @RequestBody Oficina oficina) {
           try {
               oficinaService.atualizarOficina(id, oficina);
               return ResponseEntity.ok("Oficina atualizada com sucesso!");
           } catch (Exception e){
               return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar oficina.");
           }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirOficina(@PathVariable Long id) {
            oficinaService.excluirOficina(id);
            return ResponseEntity.ok("Oficina excluída com sucesso!");

    }
}