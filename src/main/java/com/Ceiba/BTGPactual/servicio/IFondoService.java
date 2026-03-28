package com.Ceiba.BTGPactual.servicio;

import com.Ceiba.BTGPactual.modelo.Fondo;

import java.util.List;

public interface IFondoService {

    public List<Fondo> listar();

    public Fondo guardar(Fondo fondo);
}
