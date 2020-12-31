package com.example.multibanco.model.pagamento;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "pagamento")
public class Pagamento {

    @Id
    private Long cod;

    private String titular;

    private String tipo;

    private BigDecimal valor;

    private LocalDate data_pagamento;

    private String descricao;

}
