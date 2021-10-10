package com.matheus.folhapag.model;

import javax.persistence.*;

@Entity
@Table
public class Conta {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long numConta;
    private Double saldoConta;

    public Long getNumConta() {
        return numConta;
    }

    public void setNumConta(Long numConta) {
        this.numConta = numConta;
    }

    public Double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(Double saldoConta) {
        this.saldoConta = saldoConta;
    }
}
