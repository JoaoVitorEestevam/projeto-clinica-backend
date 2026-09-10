package com.github.joaovitoreestevam.clinica.repositories.medico;

import com.github.joaovitoreestevam.clinica.models.medico.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository  extends JpaRepository<Medico, Long> {
}
