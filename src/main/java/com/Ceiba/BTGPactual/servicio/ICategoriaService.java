package com.Ceiba.BTGPactual.servicio;

import com.Ceiba.BTGPactual.modelo.Categoria;

import java.util.List;

public interface ICategoriaService {
    public List<Categoria> listar();

    public Categoria guardar(Categoria categoria);
}
