package com.senac.gestaocurso.service;

import com.senac.gestaocurso.models.Turma;
import com.senac.gestaocurso.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TurmaService {
    @Autowired
    private TurmaRepository turmaRepository;
    public Turma salvar(Turma entity) {return turmaRepository.save(entity);}
    public List<Turma> buscaTodos() {
        return turmaRepository.findAll();
    }
    public Turma buscaPorId(Long id) {
        return turmaRepository.findById(id).orElse(null);
    }
    public Turma alterar(Long id, Turma alterado) {
        Optional<Turma> encontrado = turmaRepository.findById(id);
        if ((encontrado.isPresent())) {
            Turma turma = encontrado.get();
            turma.setNome(alterado.getNome());
            turma.setCurso(alterado.getCurso());
            turma.setDescricao(alterado.getDescricao());
            turma.setInscritos(alterado.getInscritos());
            turma.setDataInicio(alterado.getDataInicio());
            turma.setDataFinal(alterado.getDataFinal());
            return turmaRepository.save(turma);
        }
        return null;
    }
    public void remover(Long id) {turmaRepository.deleteById(id);
    }
}

