package com.proyecto.proyecto_farmasol.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "tb_ventas")

public class VentasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "numero_comprobante", length = 20, unique = true)
    private String numeroComprobante;
    @Column(name="id")
    private int cliente;
    @Column(name = "id", nullable = false)
    private int usuario;
    @Column(name = "fecha_venta", updatable = false)
    private LocalDateTime fechaVenta;
    @Column(nullable = false, precision = 10, scale = 2)
    private double subtotal;
    @Column(nullable = false, precision = 10, scale = 2)
    private double igv;
    @Column(nullable = false, precision = 10, scale = 2)
    private double total;
    @Enumerated(EnumType.STRING)
    @Column(name = "metodo_pago", nullable = false)
    private MetodoPago metodoPago = MetodoPago.Efectivo;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoVenta estado = EstadoVenta.Completada;
    @PrePersist
    protected void onCreate() {
        fechaVenta = LocalDateTime.now();
    }
    public enum MetodoPago {
        Efectivo,
        Tarjeta,
        Transferencia,
        Otro
    }
    public enum EstadoVenta {
        Completada,
        Anulada
    }
}
