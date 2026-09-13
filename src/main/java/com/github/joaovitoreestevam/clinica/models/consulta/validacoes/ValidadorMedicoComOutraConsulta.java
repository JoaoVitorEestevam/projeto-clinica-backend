package com.github.joaovitoreestevam.clinica.models.consulta.validacoes;

import com.github.joaovitoreestevam.clinica.dto.consulta.ConsultaCadastroDTO;
import com.github.joaovitoreestevam.clinica.repositories.consulta.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComOutraConsulta implements ValidadorAgendamentoConsulta{
    @Autowired
    ConsultaRepository repository;
    @Override
    public void validar(ConsultaCadastroDTO dto) {
     boolean consultaValida = repository.existsByMedicoIdAndDataHoraAndMotivoCancelamentoIsNull(dto.medicoId(), dto.data());

     if(consultaValida == true){
         throw new RuntimeException("Marque uma Consulta em um Horário que o Médico NÃO tenha uma consulta agendada");
     }
    }
}
