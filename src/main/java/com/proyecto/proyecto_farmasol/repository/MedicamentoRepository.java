package com.proyecto.proyecto_farmasol.repository;

import com.proyecto.proyecto_farmasol.model.MedicamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<MedicamentoEntity, Integer> {
}
