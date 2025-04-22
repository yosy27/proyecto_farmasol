package com.proyecto.proyecto_farmasol.repository;

import com.proyecto.proyecto_farmasol.model.ClientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClientesEntity, Integer> {
}
