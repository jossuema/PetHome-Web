package com.mascotasfelices.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "clients")
public class Client implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long Id;

    @Column(name = "cedula")
    private String Cedula;

    @Column(name = "nombre")
    private String Nombre;

    @Column(name = "apellido")
    private String Apellido;

    @Column(name = "email")
    private String Email;

    @Column(name = "telefono")
    private String Telefono;
}
