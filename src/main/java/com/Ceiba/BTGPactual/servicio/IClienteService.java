package com.Ceiba.BTGPactual.servicio;

import com.Ceiba.BTGPactual.modelo.Cliente;

import java.util.List;

public interface IClienteService {
    public List<Cliente> listar();

    public Cliente guardar(Cliente cliente);

}
