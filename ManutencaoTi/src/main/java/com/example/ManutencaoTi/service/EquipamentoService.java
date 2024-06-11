package com.example.ManutencaoTi.service;

import com.example.ManutencaoTi.model.Equipamento;
import com.example.ManutencaoTi.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository repository;

    public Equipamento save(Equipamento equipamento) {
        return repository.save(equipamento);
    }

    public List<Equipamento> findAll() {
        return repository.findAll();
    }

    public List<Equipamento> search(Date startDate, Date endDate, String patrimonio) {
        return repository.findByDataChegadaBetweenAndPatrimonio(startDate, endDate, patrimonio);
    }
}