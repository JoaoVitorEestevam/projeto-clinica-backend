package com.github.joaovitoreestevam.clinica.repositories;

import com.github.joaovitoreestevam.clinica.models.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
