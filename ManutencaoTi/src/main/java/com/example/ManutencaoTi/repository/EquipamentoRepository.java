package com.example.ManutencaoTi.repository;

import com.example.ManutencaoTi.model.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
    List<Equipamento> findByDataChegadaBetween(Date startDate, Date endDate);
    List<Equipamento> findByDataChegadaBetweenAndPatrimonio(Date startDate, Date endDate, String patrimonio);
}