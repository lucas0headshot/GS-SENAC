package com.senac.gestaocurso.strategy.impl;

import com.senac.gestaocurso.enterprise.ValidationException;
import com.senac.gestaocurso.models.Funcionario;
import com.senac.gestaocurso.repository.FuncionarioRepository;
import com.senac.gestaocurso.strategy.NovaValidacaoFuncionarioStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValdiarReservista implements NovaValidacaoFuncionarioStrategy {

    @Autowired
    private FuncionarioRepository repository;

    @Override
    public void validar(Funcionario funcionario) {
        if (reservistaValidado(funcionario.getReservista())){
            throw new ValidationException("Reservista já cadastrada");
        }
    }

    private boolean reservistaValidado(String reservista){
        return repository.findByReservista(reservista) != null;
    }
}
