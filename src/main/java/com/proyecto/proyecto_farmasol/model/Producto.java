package com.proyecto.proyecto_farmasol.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "tb_producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idproducto;

    @Column(name = "codprod", nullable = false, unique = true)
    private String codprod;

    @Column(name = "nomprod", nullable = false)
    private String nomprod;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "idcategoria", nullable = false)
    private int idcategoria;

    @Column(name = "fecha_vencimiento")
    private Date fechaVencimiento;

    @Column(name = "fecha_creacion", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "preprod", nullable = false)
    private double preprod;

    @Column(name = "stckprod", nullable = false)
    private int stckprod;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idcategoria", insertable = false, updatable = false)
    private Categoria categoria;

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getCodprod() {
        return codprod;
    }

    public void setCodprod(String codprod) {
        this.codprod = codprod;
    }

    public String getNomprod() {
        return nomprod;
    }

    public void setNomprod(String nomprod) {
        this.nomprod = nomprod;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getStckprod() {
        return stckprod;
    }

    public void setStckprod(int stckprod) {
        this.stckprod = stckprod;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getPreprod() {
        return preprod;
    }

    public void setPreprod(double preprod) {
        this.preprod = preprod;
    }
}
