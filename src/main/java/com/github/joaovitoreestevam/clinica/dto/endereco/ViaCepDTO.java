package com.github.joaovitoreestevam.clinica.dto.endereco;

public record ViaCepDTO(
        String cep,
        String logradouro,
        String bairro,
        String localidade,
        String uf
) {
}
