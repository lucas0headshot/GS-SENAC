package com.senac.gestaocurso.dto;

import com.senac.gestaocurso.enums.Status;
import com.senac.gestaocurso.enums.StatusInscricao;
import com.senac.gestaocurso.models.domain.Inscricao;
import java.time.LocalDate;

public class InscricaoDto {
    private  LocalDate data;
    private StatusInscricao status;
    private  Integer valor;

    public InscricaoDto(){}

    public InscricaoDto(LocalDate data, StatusInscricao status, Integer valor) {
        this.data = data;
        this.status = status;
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public StatusInscricao getStatus() {
        return status;
    }

    public void setStatus(StatusInscricao status) {
        this.status = status;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public static InscricaoDto fromEntity(Inscricao entity){
        return new InscricaoDto(
            entity.getData(),
            entity.getStatus(),
            entity.getValor()
        );
    }

    public Inscricao toEntity(){
        Inscricao entity = new Inscricao();
        entity.setData(this.data);
        entity.setStatus(this.status);
        entity.setValor(this.valor);
        return entity;
    }
}
