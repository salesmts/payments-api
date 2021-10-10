package com.matheus.folhapag.service;

import com.matheus.folhapag.model.Empresa;
import com.matheus.folhapag.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;


    @Transactional
    public Empresa salvar(Empresa empresa){

        return empresaRepository.save(empresa);

    }

    public Empresa recuperarEmpresa(Integer id){

        Optional<Empresa> optionalEmpresa = empresaRepository.findById(id);
        Empresa empresa = optionalEmpresa.get();
        return empresa;
    }
}
