package com.github.joaovitoreestevam.clinica.dto.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ConsultaCadastroDTO(
        @NotNull(message = "O ID do médico é obrigatório")
        Long medicoId,

        @NotNull(message = "O ID do paciente é obrigatório")
        Long pacienteId,

        @NotNull(message = "A data da consulta é obrigatória")
        @Future(message = "a consulta deve ser agendada em uma data futura")
        LocalDateTime data
) {
}
