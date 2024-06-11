package com.example.ManutencaoTi.controller;

import com.example.ManutencaoTi.model.Equipamento;
import com.example.ManutencaoTi.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {

    @Autowired
    private EquipamentoService service;

    @PostMapping("/cadastro")
    public Equipamento cadastrar(@RequestBody Equipamento equipamento) {
        return service.save(equipamento);
    }

    @GetMapping("/pesquisa")
    public List<Equipamento> pesquisar(@RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate, @RequestParam("patrimonio") String patrimonio) {
        return service.search(startDate, endDate, patrimonio);
    }

    @GetMapping
    public List<Equipamento> listar() {
        return service.findAll();
    }
}