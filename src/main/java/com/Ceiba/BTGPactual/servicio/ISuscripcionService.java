package com.Ceiba.BTGPactual.servicio;

import com.Ceiba.BTGPactual.modelo.Suscripcion;

import java.util.List;

public interface ISuscripcionService {

    public List<Suscripcion> listar();

    public Suscripcion guardar(Suscripcion suscripcion);
}
