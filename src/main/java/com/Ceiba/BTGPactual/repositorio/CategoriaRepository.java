package com.Ceiba.BTGPactual.repositorio;

import com.Ceiba.BTGPactual.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}