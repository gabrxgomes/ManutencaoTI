package com.example.ManutencaoTi.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ManutencaoTi.model.Equipamento;
import com.example.ManutencaoTi.repository.EquipamentoRepository;

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
        if (patrimonio == null || patrimonio.isEmpty()) {
            return repository.findByDataChegadaBetween(startDate, endDate);
        } else {
            return repository.findByDataChegadaBetweenAndPatrimonio(startDate, endDate, patrimonio);
        }
    }
}