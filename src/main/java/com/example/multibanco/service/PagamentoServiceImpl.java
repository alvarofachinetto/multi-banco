package com.example.multibanco.service;

import com.example.multibanco.model.cliente.Cliente;
import com.example.multibanco.model.pagamento.Pagamento;
import com.example.multibanco.repository.pagamento.PagamentoRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoServiceImpl implements PagamentoService{

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Override
    public List<Pagamento> listPagamentos(String titular) {
        List<Pagamento> pagamentosDoTitular = pagamentoRepository.pagamentoPorTitular(titular);
        return pagamentosDoTitular;
    }

    @Override
    public Pagamento save(Pagamento pagamento) {
        Optional<Pagamento> pagamentoOp = pagamentoRepository.findById(pagamento.getCod());

        if(pagamentoOp.isPresent())
            return pagamentoRepository.save(pagamento);
        else
            return pagamentoRepository.save(pagamento);
    }
}
