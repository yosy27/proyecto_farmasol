package com.proyecto.proyecto_farmasol.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(nullable = false, length = 100)
    private String apellido;
    @Column(nullable = false, unique = true, length = 50)
    private String usuario;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true, length = 100)
    private String correo;
    private boolean activo = true;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaRegistro;
    @Column(name = "ultima_actualizacion")
    private LocalDateTime ultimaActualizacion;
}


