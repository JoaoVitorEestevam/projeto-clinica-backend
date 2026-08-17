package com.github.joaovitoreestevam.clinica.dto.paciente;

import com.github.joaovitoreestevam.clinica.dto.endereco.EnderecoDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PacienteCadastroDTO(
        @NotBlank(message = "Nome é obrigatório")
        String nome,

        String email,

        String telefone,

        @NotBlank(message = "CPF é obrigatório")
        @Pattern(regexp = "\\d{11}", message = "CPF deve conter exatamente 11 dígitos numéricos")
        String cpf,

        @NotNull(message = "Endereço é obrigatório")
        EnderecoDTO endereco
) {
}
