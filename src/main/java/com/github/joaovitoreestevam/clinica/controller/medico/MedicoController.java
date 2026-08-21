package com.github.joaovitoreestevam.clinica.controller.medico;


import com.github.joaovitoreestevam.clinica.dto.medico.MedicoCadastroDTO;
import com.github.joaovitoreestevam.clinica.models.medico.Medico;
import com.github.joaovitoreestevam.clinica.repositories.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid MedicoCadastroDTO dto){
       Medico medico = new Medico(dto);

        repository.save(medico);
    }
}
