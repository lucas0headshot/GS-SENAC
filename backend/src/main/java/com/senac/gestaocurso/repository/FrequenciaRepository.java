package com.senac.gestaocurso.repository;

import com.senac.gestaocurso.models.Frequencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrequenciaRepository extends JpaRepository<Frequencia, Long> {
}
