package com.github.joaovitoreestevam.clinica.models.consulta.validacoes;

import com.github.joaovitoreestevam.clinica.dto.consulta.ConsultaCadastroDTO;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioConsulta implements ValidadorAgendamentoConsulta{
    @Override
    public void validar(ConsultaCadastroDTO dto) {
        if(dto.data().getDayOfWeek().equals(DayOfWeek.SUNDAY) || dto.data().getHour() < 7 || dto.data().getHour() > 18 || (dto.data().getHour() == 18 && dto.data().getMinute() > 0)){

            throw new RuntimeException("Marque a Consulta em Horário Comercial");

        }
    }
}
