package com.joaquimFelix.ODSU.controller.oficina;

import com.joaquimFelix.ODSU.model.entity.Oficina;
import com.joaquimFelix.ODSU.service.oficina.OficinaService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String cadastrarOficina(@ModelAttribute Oficina oficina) {
        oficinaService.cadastrarOficina(oficina);
        // redirecionar para a página principal ou para onde for apropriado
        return "redirect:/oficinas";
    }

    @PutMapping("/{id}")
    public Oficina atualizarOficina(@PathVariable Long id, @RequestBody Oficina oficina) {
        return oficinaService.atualizarOficina(id, oficina);
    }

    @DeleteMapping("/{id}")
    public void excluirOficina(@PathVariable Long id) {
        oficinaService.excluirOficina(id);
    }
}