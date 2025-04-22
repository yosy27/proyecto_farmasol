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
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClientesEntity cliente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;
    @Column(name = "fecha_venta", updatable = false)
    private LocalDateTime fechaVenta;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotal;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal igv;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total;
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
