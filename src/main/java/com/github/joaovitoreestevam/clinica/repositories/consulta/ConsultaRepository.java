package com.github.joaovitoreestevam.clinica.repositories.consulta;

import com.github.joaovitoreestevam.clinica.models.consulta.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {


    boolean existsByMedicoIdAndDataHoraAndMotivoCancelamentoIsNull(Long medicoId, LocalDateTime data);

    boolean existsByPacienteIdAndDataHoraBetweenAndMotivoCancelamentoIsNull(Long pacienteId, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);
}
