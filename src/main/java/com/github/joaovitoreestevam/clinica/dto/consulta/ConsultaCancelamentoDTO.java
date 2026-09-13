package com.github.joaovitoreestevam.clinica.dto.consulta;

import com.github.joaovitoreestevam.clinica.models.consulta.MotivoCancelamento;
import jakarta.validation.constraints.NotNull;

public record ConsultaCancelamentoDTO(
        @NotNull(message = "O id da consulta é obrigatório")
        Long id,
        @NotNull(message = "O motivo do cancelamento é obrigatório")
        MotivoCancelamento motivo

) {
}
