package com.github.joaovitoreestevam.clinica.dto.medico;

import com.github.joaovitoreestevam.clinica.models.medico.Especialidades;
import com.github.joaovitoreestevam.clinica.models.medico.Medico;

public record MedicoListagemDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        String crm,
        Especialidades especialidade
) {
    public MedicoListagemDTO(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade());
    }
}
