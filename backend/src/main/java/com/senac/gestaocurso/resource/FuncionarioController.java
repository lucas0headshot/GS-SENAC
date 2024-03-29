package com.senac.gestaocurso.resource;


import com.senac.gestaocurso.models.Funcionario;
import com.senac.gestaocurso.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/api/funcionario")

public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping()
    public ResponseEntity salvar(@RequestBody Funcionario funcionario){
        Funcionario save = funcionarioService.salvar(funcionario);
        return ResponseEntity.created(URI.create("/funcionario/salvar" + funcionario.getId())).body(save);
    }


    @GetMapping
    public  ResponseEntity findAll() {
        List<Funcionario> funcionarios = funcionarioService.buscaTodos();
        return ResponseEntity.ok(funcionarios);
    }
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Funcionario funcionario = funcionarioService.buscaPorId(id);
        return ResponseEntity.ok().body(funcionario);
    }



    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        funcionarioService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Funcionario entity){
        Funcionario alterado = funcionarioService.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}



