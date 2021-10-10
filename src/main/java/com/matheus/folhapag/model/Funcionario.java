package com.matheus.folhapag.model;

import javax.persistence.*;

@Entity
@Table
public class Funcionario {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Empresa empresa;
    private String nome;
    @OneToOne(cascade = CascadeType.ALL)
    private Conta conta;

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

}
