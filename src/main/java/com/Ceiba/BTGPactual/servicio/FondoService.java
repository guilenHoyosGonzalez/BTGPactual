package com.Ceiba.BTGPactual.servicio;


import com.Ceiba.BTGPactual.modelo.Fondo;
import com.Ceiba.BTGPactual.repositorio.FondoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FondoService implements IFondoService{

    @Autowired
    FondoRepository fondoRepository;

    @Override
    public List<Fondo> listar() {
        return fondoRepository.findAll();
    }

    @Override
    public Fondo guardar(Fondo fondo) {
        return fondoRepository.save(fondo);
    }
}
