package com.matheus.folhapag.controller;

import com.matheus.folhapag.model.Conta;
import com.matheus.folhapag.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping
    public Conta salvar(@RequestBody Conta conta){
        return contaService.salvar(conta);

    }
}
