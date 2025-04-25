package com.proyecto.proyecto_farmasol.repository;

import com.proyecto.proyecto_farmasol.model.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Integer> {

    List<ProveedorEntity> findByEstado(ProveedorEntity.EstadoProveedor estado);

    List<ProveedorEntity> findByNombreContaining(String nombre);
}
