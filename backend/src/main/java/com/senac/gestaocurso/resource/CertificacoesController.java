package com.senac.gestaocurso.resource;

import com.senac.gestaocurso.models.Certificacoes;
import com.senac.gestaocurso.service.CertificacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/certificacoes")
public class CertificacoesController {

        @Autowired
        private CertificacoesService certificacoesService;

        @PostMapping()
        public ResponseEntity salvar(@RequestBody Certificacoes certificacoes){
            Certificacoes save = certificacoesService.salvar(certificacoes);
            return ResponseEntity.created(URI.create("/funcionario/salvar" + certificacoes.getId())).body(save);
        }

        @GetMapping
        public  ResponseEntity findAll() {
            List<Certificacoes> certificacoes = certificacoesService.buscaTodos();
            return ResponseEntity.ok(certificacoes);
        }
        @GetMapping("/{id}")
        public  ResponseEntity findById(@PathVariable("id") Long id){
            Certificacoes certificacoes = certificacoesService.buscaPorId(id);
            return ResponseEntity.ok().body(certificacoes);
        }

        @DeleteMapping("{id}")
        public  ResponseEntity remove(@PathVariable("id") Long id){
            certificacoesService.remover(id);
            return ResponseEntity.noContent().build();
        }

        @PutMapping("{id}")
        public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Certificacoes entity){
            Certificacoes alterado = certificacoesService.alterar(id, entity);
            return  ResponseEntity.ok().body(alterado);
        }
    }

