package com.github.joaovitoreestevam.clinica.dto.medico;

import com.github.joaovitoreestevam.clinica.dto.endereco.EnderecoAtualizacaoDTO;
import com.github.joaovitoreestevam.clinica.dto.endereco.EnderecoDTO;
import jakarta.validation.constraints.NotNull;

public record MedicoAtualizacaoDTO(
        @NotNull(message = "O ID é obrigatório!")
        Long id,
        String nome,
        String email,
        String telefone,
        EnderecoAtualizacaoDTO endereco
) {
    public MedicoAtualizacaoDTO{
        nome = (nome != null && nome.isBlank()) ? null : nome;
        email = (email != null && email.isBlank()) ? null : email ;
        telefone = (telefone != null && telefone.isBlank()) ? null : telefone;
    }
}
