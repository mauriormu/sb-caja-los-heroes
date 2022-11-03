package com.losheroes.app.cliente.services;

import com.losheroes.app.cliente.entities.Cliente;
import com.losheroes.app.cliente.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Cliente service implement.
 */
@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;



    @Override
    public Cliente obtenerClienteById(Integer id) {
        return clienteRepository.findById(id).get();
    }


    @Override
    public Boolean eliminarCliente(Integer id) {

        try{
            clienteRepository.deleteById(id);
            return true;
        }catch(Exception ex){
            return false;
        }

    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> obtenerClientes(){
        return clienteRepository.findAll();
    }
    @Override
    public Cliente guardarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

}
