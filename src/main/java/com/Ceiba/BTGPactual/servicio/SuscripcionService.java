package com.Ceiba.BTGPactual.servicio;

import com.Ceiba.BTGPactual.modelo.Suscripcion;
import com.Ceiba.BTGPactual.repositorio.SuscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuscripcionService implements  ISuscripcionService {

    @Autowired
    SuscripcionRepository suscripcionRepository;

    @Override
    public List<Suscripcion> listar() {
        return suscripcionRepository.findAll();
    }

    @Override
    public Suscripcion guardar(Suscripcion suscripcion) {
        return suscripcionRepository.save(suscripcion);
    }
}
