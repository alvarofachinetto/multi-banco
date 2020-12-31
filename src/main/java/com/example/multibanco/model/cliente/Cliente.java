package com.example.multibanco.model.cliente;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    private Long id;

    private String nome;

    private String cpf;

    private String email;

    private String telefone;

}
