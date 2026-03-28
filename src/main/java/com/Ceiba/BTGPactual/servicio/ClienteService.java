package com.Ceiba.BTGPactual.servicio;

import com.Ceiba.BTGPactual.modelo.Cliente;
import com.Ceiba.BTGPactual.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private ClienteRepository clienteRepository;


    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

}
