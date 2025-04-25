package com.proyecto.proyecto_farmasol.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "proveedores")
public class ProveedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Integer idProveedor;

    @NotBlank(message = "El nombre del proveedor es obligatorio")
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "contacto")
    private String contacto;

    @Column(name = "telefono")
    private String telefono;

    @Email(message = "El formato del email no es válido")
    @Column(name = "email")
    private String email;

    @Column(name = "direccion")
    private String direccion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoProveedor estado;

    @PrePersist
    public void prePersist() {
        if (estado == null) {
            estado = EstadoProveedor.ACTIVO;
        }
    }

    public enum EstadoProveedor {
        ACTIVO, INACTIVO
    }
}
