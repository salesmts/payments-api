package com.matheus.folhapag.controller;

import com.matheus.folhapag.model.Conta;
import com.matheus.folhapag.model.Empresa;
import com.matheus.folhapag.model.Funcionario;
import com.matheus.folhapag.service.EmpresaService;
import com.matheus.folhapag.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;
    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<Empresa> salvar(@RequestBody Empresa empresa){

        return ResponseEntity.ok(empresaService.salvar(empresa));
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Double> recuperarEmpresa(@PathVariable("id") Integer id){

        Empresa empresa = empresaService.recuperarEmpresa(id);
        Conta conta = empresa.getConta();
        return ResponseEntity.ok(conta.getSaldoConta());
    }

    @PostMapping(path = "{id}/funcionarios")
    public ResponseEntity<?> adicionarFuncionario(@PathVariable("id") Integer id, @RequestBody Funcionario funcionario){

        Empresa empresa = empresaService.recuperarEmpresa(id);
        empresa.adicionarFuncionario(funcionario);
        empresaService.salvar(empresa);
        return ResponseEntity.ok().build();

    }

    // Nesta parte usei o System.out para gerar log no console, e determinar possível erro no algoritmo
    // da API de transferência empresa-funcionário.
    @PostMapping(path = "{idEmpresa}/funcionarios/{idFuncionario}")
    public ResponseEntity<?> transferirDinheiro(@PathVariable("idEmpresa") Integer idEmpresa, @PathVariable("idFuncionario")
            Long idFuncionario, @RequestParam Double saldoConta){

        Empresa empresa = empresaService.recuperarEmpresa(idEmpresa);
        System.out.println("Recuperando empresa de id " + idEmpresa); // Logs

        Funcionario funcionario = funcionarioService.recuperarFuncionario(idFuncionario);
        System.out.println("Recuperando funcionario de id " + idFuncionario); // Logs

        Conta conta = empresa.getConta();
        System.out.println("Recuperando conta da empresa com o saldo " + conta.getSaldoConta()); // Logs

        Conta contaFuncionario = funcionario.getConta();
        System.out.println("Recuperando conta do funcionario com saldo " + contaFuncionario.getSaldoConta()); // Logs

        Double saldoNovo = conta.getSaldoConta()-saldoConta;
        System.out.println("Novo saldo da conta da empresa " + saldoNovo); // Logs

        conta.setSaldoConta(saldoNovo);

        Double saldoFuncionario = contaFuncionario.getSaldoConta()+saldoConta;
        System.out.println("Novo saldo da conta do funcionario " + saldoFuncionario); // Logs

        contaFuncionario.setSaldoConta(saldoFuncionario);

        empresaService.salvar(empresa);
        System.out.println("Empresa salva com sucesso!"); // Logs

        return ResponseEntity.ok().build();


    }


}
