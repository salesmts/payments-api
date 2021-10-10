package com.matheus.folhapag.service;

import com.matheus.folhapag.model.Conta;
import com.matheus.folhapag.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public Conta salvar(Conta conta){
        return contaRepository.save(conta);

    }
}
