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
    private int id;
    private String codigo;
    private String descripcion;
    private int stock;
    private int idcategoria;
    private Double precioVenta;
    private LocalDateTime fechaRegistro;
    private Date fechaVencimiento;



}
