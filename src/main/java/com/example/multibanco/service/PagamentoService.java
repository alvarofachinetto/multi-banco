package com.example.multibanco.service;

import com.example.multibanco.model.pagamento.Pagamento;

import java.util.List;

public interface PagamentoService {
    List<Pagamento> listPagamentos(String titular);

    Pagamento save(Pagamento pagamento);

}
