package com.matheus.folhapag.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Empresa {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String nome;
    @OneToOne(cascade = CascadeType.ALL)
    private Conta conta;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Funcionario> funcionarios;



    public void adicionarFuncionario(Funcionario funcionario){
        funcionario.setEmpresa(this);
        this.funcionarios.add(funcionario);

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
