package com.matheus.folhapag.service;

import com.matheus.folhapag.model.Funcionario;
import com.matheus.folhapag.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario salvar(Funcionario funcionario){

        return funcionarioRepository.save(funcionario);

    }

    public Funcionario recuperarFuncionario(Long id){

        Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(id);
        Funcionario funcionario = optionalFuncionario.get();
        return funcionario;

    }

}
