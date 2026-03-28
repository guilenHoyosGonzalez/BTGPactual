package com.Ceiba.BTGPactual.repositorio;

import com.Ceiba.BTGPactual.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}