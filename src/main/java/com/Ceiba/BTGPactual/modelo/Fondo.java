package com.Ceiba.BTGPactual.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@ToString
@EqualsAndHashCode
public class Fondo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double montoMinimo;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;


    public Fondo() {
    }

    public Fondo(String nombre, Categoria categoria, Double montoMinimo, Long id) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.montoMinimo = montoMinimo;
        this.id = id;
    }

    public Double getMontoMinimo() {
        return montoMinimo;
    }

    public void setMontoMinimo(Double montoMinimo) {
        this.montoMinimo = montoMinimo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}