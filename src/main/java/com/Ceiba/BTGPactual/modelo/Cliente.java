package com.Ceiba.BTGPactual.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@EqualsAndHashCode
@ToString
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double saldo;
    private String email;
    private String telefono;
    private String preferenciaNotificacion;

    public Cliente() {
    }

    public Cliente(Long id, String nombre, Double saldo, String telefono, String email, String preferenciaNotificacion) {
        this.id = id;
        this.nombre = nombre;
        this.saldo = saldo;
        this.telefono = telefono;
        this.email = email;
        this.preferenciaNotificacion = preferenciaNotificacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPreferenciaNotificacion() {
        return preferenciaNotificacion;
    }

    public void setPreferenciaNotificacion(String preferenciaNotificacion) {
        this.preferenciaNotificacion = preferenciaNotificacion;
    }
}
