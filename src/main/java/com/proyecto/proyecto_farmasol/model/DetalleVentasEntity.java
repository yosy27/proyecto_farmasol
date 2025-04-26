package com.proyecto.proyecto_farmasol.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "detalle_ventas")
public class DetalleVentasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "venta_id")
    private int venta;
    @Column(name = "medicamento_id")
    private int medicamento;
    @Column(nullable = false)
    private Integer cantidad;
    @Column(name = "precio_unitario", nullable = false)
    private double precioUnitario;
    @Column(nullable = false)
    private double subtotal;
    @Column(nullable = false)
    private Boolean receta = false;

}
