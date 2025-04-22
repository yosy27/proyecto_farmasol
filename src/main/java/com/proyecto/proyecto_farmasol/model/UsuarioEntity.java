package com.proyecto.proyecto_farmasol.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String apellido;
    @Column(unique = true)
    private String usuario;
    @Column(unique = true)
    private String email;
    private String password;
    private boolean activo = true;
    private LocalDateTime fechaRegistro;

}


