package com.github.joaovitoreestevam.clinica.models.consulta.validacoes;

import com.github.joaovitoreestevam.clinica.dto.consulta.ConsultaCadastroDTO;

public interface ValidadorAgendamentoConsulta {
    void validar(ConsultaCadastroDTO dto);
}
