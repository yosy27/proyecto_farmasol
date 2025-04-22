package com.proyecto.proyecto_farmasol.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_medicamentos")
public class MedicamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idmed;
    private String codigo;
    private String nombre;
    private String descripcion;
    private int stock;
    private int idcategoria;
    private Double precioVenta;
    private LocalDateTime fechaRegistro;
    private Date fechaVencimiento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoriaid")  // clave foránea en la tabla medicamentos
    private CategoriaEntity categoriaid;



}
