package com.github.joaovitoreestevam.clinica.dto.paciente;

import com.github.joaovitoreestevam.clinica.models.paciente.Paciente;

public record PacienteListagemDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        String cpf
) {
    public PacienteListagemDTO(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf());
    }
}
