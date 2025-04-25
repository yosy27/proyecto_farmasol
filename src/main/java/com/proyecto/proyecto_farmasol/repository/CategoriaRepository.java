package com.proyecto.proyecto_farmasol.repository;

import com.proyecto.proyecto_farmasol.model.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Integer> {
    Optional<CategoriaEntity> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
