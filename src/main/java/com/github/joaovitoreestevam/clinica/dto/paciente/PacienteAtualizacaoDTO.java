package com.github.joaovitoreestevam.clinica.dto.paciente;

import com.github.joaovitoreestevam.clinica.dto.endereco.EnderecoAtualizacaoDTO;
import jakarta.validation.constraints.NotNull;

public record PacienteAtualizacaoDTO(
        @NotNull(message = "O ID é obrigatório!")
        Long id,
        String nome,
        String email,
        String telefone,
        EnderecoAtualizacaoDTO endereco
) {
    public PacienteAtualizacaoDTO{
        nome = (nome != null && nome.isBlank()) ? null : nome;
        email = (email != null && email.isBlank()) ? null : email;
        telefone = (telefone != null && telefone.isBlank()) ? null : telefone;
    }
}
