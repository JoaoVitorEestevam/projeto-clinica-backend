package com.github.joaovitoreestevam.clinica.models.paciente;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

enum Uf {
    AC, AM, AP, PA, RO, RR, TO, AL, BA, CE, MA, PB, PE, PI, RN, SE, DF, GO, MT, MS, ES, MG, SP, RJ, PR, RS, SC
}
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
}
