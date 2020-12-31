package com.example.multibanco.repository.pagamento;

import com.example.multibanco.model.pagamento.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    @Query("SELECT p FROM Pagamento p where p.titular LIKE CONCAT('%', :titular, '%')")
    List<Pagamento> pagamentoPorTitular(@Param("titular") String titular);
}
