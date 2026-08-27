package com.github.joaovitoreestevam.clinica.dto.endereco;

import com.github.joaovitoreestevam.clinica.models.endereco.Uf;
import jakarta.validation.constraints.NotNull;

public record EnderecoAtualizacaoDTO(
        String cep,
        String logradouro,
        String bairro,
        String cidade,
        Uf uf,
        String numero
) {
    public EnderecoAtualizacaoDTO{
        cep = (cep != null && cep.isBlank()) ? null : cep ;
        logradouro = (logradouro != null && logradouro.isBlank()) ? null : logradouro;
        bairro = (bairro != null && bairro.isBlank()) ? null : bairro;
        cidade = (cidade != null && cidade.isBlank()) ? null : cidade;
        numero = (numero != null && numero.isBlank()) ? null : numero;
    }
}
