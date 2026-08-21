package com.github.joaovitoreestevam.clinica.models.endereco;

import com.github.joaovitoreestevam.clinica.dto.endereco.EnderecoDTO;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    @NotBlank
    private String cep;

    @NotBlank
    private String logradouro;

    @NotBlank
    private String bairro;

    @NotBlank
    private String cidade;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Uf uf;

    private String numero;


    public Endereco(EnderecoDTO dto){
     this.cep = dto.cep();
     this.logradouro = dto.logradouro();
     this.bairro = dto.bairro();
     this.cidade = dto.cidade();
     this.uf = dto.uf();
     this.numero = dto.numero();
    }
}
