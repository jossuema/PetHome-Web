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
@Table(name = "products")
public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private long Id;

    @Column(name="nombre")
    private String Nombre;

    @Column(name="precio")
    private double Precio;

    @Column(name="stock")
    private int Stock;

    @Column(name="categoria")
    private String Categoria;

    @Column(name="disponible")
    private boolean Disponible;
}
