package com.example.multibanco.service;

import com.example.multibanco.model.cliente.Cliente;
import com.example.multibanco.model.pagamento.Pagamento;
import com.example.multibanco.repository.cliente.ClienteRepository;
import com.example.multibanco.repository.pagamento.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes;
    }

    @Override
    public Cliente save(Cliente cliente) {
         Optional<Cliente> clienteOp = clienteRepository.findById(cliente.getId());

         if(clienteOp.isPresent())
             return clienteRepository.save(cliente);
         else
             return clienteRepository.save(cliente);
    }
}
