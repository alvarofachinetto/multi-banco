package com.example.multibanco.service;

import com.example.multibanco.model.cliente.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> listClientes();

    Cliente save(Cliente cliente);
}
