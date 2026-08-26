package com.github.joaovitoreestevam.clinica.controller.paciente;

import com.github.joaovitoreestevam.clinica.dto.paciente.PacienteCadastroDTO;
import com.github.joaovitoreestevam.clinica.dto.paciente.PacienteListagemDTO;
import com.github.joaovitoreestevam.clinica.models.paciente.Paciente;
import com.github.joaovitoreestevam.clinica.repositories.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
   private PacienteRepository repository;

    @GetMapping
    public Page<PacienteListagemDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(PacienteListagemDTO::new);
    }

    @PostMapping
    public void cadastrar(@RequestBody @Valid PacienteCadastroDTO dto){
        Paciente paciente = new Paciente(dto);

        repository.save(paciente);
    }
}
