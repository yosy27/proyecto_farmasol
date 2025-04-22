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
    @ManyToOne(optional = false)
    @JoinColumn(name = "venta_id", referencedColumnName = "id")
    private VentasEntity venta;
    @ManyToOne(optional = false)
    @JoinColumn(name = "medicamento_id", referencedColumnName = "id")
    private MedicamentoEntity medicamento;
    @Column(nullable = false)
    private Integer cantidad;
    @Column(name = "precio_unitario", nullable = false, precision = 10, scale = 2)
    private double precioUnitario;
    @Column(nullable = false, precision = 10, scale = 2)
    private double subtotal;
    @Column(nullable = false)
    private Boolean receta = false;

}
