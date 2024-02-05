package com.davismotors.estoquecarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davismotors.estoquecarros.model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {

}
