package com.proyecto.proyecto_farmasol.repository;

import com.proyecto.proyecto_farmasol.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {
}
