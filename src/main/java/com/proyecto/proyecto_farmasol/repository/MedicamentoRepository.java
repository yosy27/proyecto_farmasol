package com.proyecto.proyecto_farmasol.repository;

import com.proyecto.proyecto_farmasol.model.CategoriaEntity;
import com.proyecto.proyecto_farmasol.model.MedicamentoEntity;
import com.proyecto.proyecto_farmasol.model.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MedicamentoRepository extends JpaRepository<MedicamentoEntity, Integer> {

    Optional<MedicamentoEntity> findByCodigoBarras(String codigoBarras);
    List<MedicamentoEntity> findByNombreContaining(String nombre);
    List<MedicamentoEntity> findByCategoria(CategoriaEntity categoria);
    List<MedicamentoEntity> findByProveedor(ProveedorEntity proveedor);
    List<MedicamentoEntity> findByRequiereReceta(Boolean requiereReceta);

    @Query("SELECT m FROM Medicamento m WHERE m.stockActual <= m.stockMinimo")
    List<MedicamentoEntity> findWithLowStock();

    @Query("SELECT m FROM Medicamento m WHERE m.fechaVencimiento <= :fecha")
    List<MedicamentoEntity> findExpiringBefore(@Param("fecha") LocalDate fecha);

    @Query("SELECT m FROM Medicamento m WHERE LOWER(m.nombre) LIKE LOWER(CONCAT('%', :termino, '%')) OR LOWER(m.principioActivo) LIKE LOWER(CONCAT('%', :termino, '%'))")
    List<MedicamentoEntity> busquedaGenerica(@Param("termino") String termino);
}
