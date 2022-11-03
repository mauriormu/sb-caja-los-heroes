package com.losheroes.app.cliente.services;

import com.losheroes.app.cliente.entities.Cliente;

import java.util.List;

public interface ClienteService {


    Cliente obtenerClienteById(Integer id);

    Boolean eliminarCliente(Integer id);

    Cliente actualizarCliente(Cliente cliente);

    List<Cliente> obtenerClientes();

    Cliente guardarCliente(Cliente cliente);

}
