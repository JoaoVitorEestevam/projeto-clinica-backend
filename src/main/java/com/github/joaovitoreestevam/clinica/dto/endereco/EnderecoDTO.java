package com.github.joaovitoreestevam.clinica.dto.endereco;

import com.github.joaovitoreestevam.clinica.models.endereco.Uf;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EnderecoDTO(
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,

        @NotBlank
        String logradouro,

        @NotBlank
        String bairro,

        @NotBlank
        String cidade,

        @NotNull
        Uf uf,

        String numero
) {}