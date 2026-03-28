package com.Ceiba.BTGPactual.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode
public class Suscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUnico;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "fondo_id")
    private Fondo fondo;

    private String tipo;
    private Double monto;
    private LocalDate fecha;

    public Suscripcion() {
    }

    public Suscripcion(LocalDate fecha, Double monto, Fondo fondo, String tipo, Cliente cliente, Long idUnico) {
        this.fecha = fecha;
        this.monto = monto;
        this.fondo = fondo;
        this.tipo = tipo;
        this.cliente = cliente;
        this.idUnico = idUnico;
    }

    public Long getIdUnico() {
        return idUnico;
    }

    public void setIdUnico(Long idUnico) {
        this.idUnico = idUnico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Fondo getFondo() {
        return fondo;
    }

    public void setFondo(Fondo fondo) {
        this.fondo = fondo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}