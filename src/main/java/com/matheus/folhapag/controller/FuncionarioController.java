package com.matheus.folhapag.controller;

import com.matheus.folhapag.model.Conta;
import com.matheus.folhapag.model.Funcionario;
import com.matheus.folhapag.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public Funcionario salvar(@RequestBody Funcionario funcionario){
        return funcionarioService.salvar(funcionario);

    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Double> recuperarFuncionario(@PathVariable("id") Long id) {
        Funcionario funcionario = funcionarioService.recuperarFuncionario(id);
        Conta contaFuncionario = funcionario.getConta();
        return ResponseEntity.ok(contaFuncionario.getSaldoConta());
    }
}
