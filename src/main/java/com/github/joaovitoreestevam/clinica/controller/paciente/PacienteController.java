package com.github.joaovitoreestevam.clinica.controller.paciente;

import com.github.joaovitoreestevam.clinica.dto.paciente.PacienteCadastroDTO;
import com.github.joaovitoreestevam.clinica.models.paciente.Paciente;
import com.github.joaovitoreestevam.clinica.repositories.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
   private PacienteRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid PacienteCadastroDTO dto){
        Paciente paciente = new Paciente(dto);

        repository.save(paciente);
    }
}
