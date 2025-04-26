package com.proyecto.proyecto_farmasol.repository;

import com.proyecto.proyecto_farmasol.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> {

    //Buscar producto por codigo
    Producto findByCodprod(String codprod);
}
