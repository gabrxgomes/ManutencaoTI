package com.example.ManutencaoTi.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ManutencaoTi.model.Equipamento;
import com.example.ManutencaoTi.service.EquipamentoService;

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
    public List<Equipamento> pesquisar(
        @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
        @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate,
        @RequestParam(value = "patrimonio", required = false) String patrimonio) {
        return service.search(startDate, endDate, patrimonio);
    }

    @GetMapping
    public List<Equipamento> listar() {
        return service.findAll();
    }
}