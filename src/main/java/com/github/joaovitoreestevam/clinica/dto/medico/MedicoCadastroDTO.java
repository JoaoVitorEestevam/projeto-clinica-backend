package com.github.joaovitoreestevam.clinica.dto.medico;

import com.github.joaovitoreestevam.clinica.dto.endereco.EnderecoDTO;
import com.github.joaovitoreestevam.clinica.models.medico.Especialidades;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicoCadastroDTO(
        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Email inválido")
        String email,

        String telefone,

        @NotBlank(message = "CRM é obrigatório")
        @Pattern(regexp = "\\d{4,6}", message = "CRM deve ter de 4 a 6 dígitos numéricos")
        String crm,

        @NotNull(message = "Especialidade é obrigatória")
        Especialidades especialidade,

        @NotNull(message = "Endereço é obrigatório")
        EnderecoDTO endereco
) {}
