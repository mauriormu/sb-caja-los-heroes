package com.losheroes.app.cliente.repositories;

import com.losheroes.app.cliente.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
