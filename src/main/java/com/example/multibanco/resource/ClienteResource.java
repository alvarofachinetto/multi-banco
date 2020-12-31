package com.example.multibanco.resource;


import com.example.multibanco.model.cliente.Cliente;
import com.example.multibanco.model.pagamento.Pagamento;
import com.example.multibanco.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listaDeCliente(){
        List<Cliente> clientes = clienteService.listClientes();
        return ResponseEntity.status(200).body(clientes);
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){

        Cliente novoCliente = clienteService.save(cliente);

        if(cliente.equals(novoCliente)){
            return ResponseEntity.status(200).body(novoCliente);
        }else if(!cliente.equals(novoCliente))
            return ResponseEntity.status(201).body(novoCliente);
        return ResponseEntity.status(400).build();
    }


}
