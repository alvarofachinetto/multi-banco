package com.example.multibanco.resource;

import com.example.multibanco.model.pagamento.Pagamento;
import com.example.multibanco.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoResource {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping("/{titular}")
    public ResponseEntity<List<Pagamento>> listaDePagamentos(
            @PathVariable String titular){
        List<Pagamento> pagamentos = pagamentoService.listPagamentos(titular);
        return ResponseEntity.status(200).body(pagamentos);
    }

    @PostMapping
    public ResponseEntity<Pagamento> save(@RequestBody Pagamento pagamento){
        Pagamento novoPagamento = pagamentoService.save(pagamento);

        if(pagamento.equals(novoPagamento)){
            return ResponseEntity.status(200).body(novoPagamento);
        }else if(!pagamento.equals(novoPagamento))
            return ResponseEntity.status(201).body(novoPagamento);
        return ResponseEntity.status(400).build();
    }

}
