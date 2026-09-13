package com.github.joaovitoreestevam.clinica.models.consulta.validacoes;

import com.github.joaovitoreestevam.clinica.dto.consulta.ConsultaCadastroDTO;
import com.github.joaovitoreestevam.clinica.repositories.consulta.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class ValidadorPacienteComOutraConsulta implements ValidadorAgendamentoConsulta{
    @Autowired
    ConsultaRepository repository;
    @Override
    public void validar(ConsultaCadastroDTO dto) {
        LocalDateTime primeiroHorario = dto.data().withHour(7).withMinute(0).withSecond(0);
        LocalDateTime segundoHorario = dto.data().withHour(18).withMinute(0).withSecond(0);

        boolean consultaValida = repository.existsByPacienteIdAndDataHoraBetweenAndMotivoCancelamentoIsNull(dto.pacienteId(), primeiroHorario, segundoHorario);

        if(consultaValida == true){
            throw new RuntimeException("Marque uma Consulta em um dia que o Paciente NÃO tenha uma consulta agendada");
        }
    }
}
