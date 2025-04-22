package com.proyecto.proyecto_farmasol.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_detalle_ventas")
public class DetalleVentasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "id")
    private int venta;
    @Column(name = "id")
    private int medicamento;
    @Column(nullable = false)
    private Integer cantidad;
    @Column(name = "precio_unitario", nullable = false, precision = 10, scale = 2)
    private double precioUnitario;
    @Column(nullable = false, precision = 10, scale = 2)
    private double subtotal;
    @Column(nullable = false)
    private Boolean receta = false;

}
