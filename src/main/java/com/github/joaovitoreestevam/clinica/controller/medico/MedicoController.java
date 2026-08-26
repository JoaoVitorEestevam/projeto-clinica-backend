package com.github.joaovitoreestevam.clinica.controller.medico;


import com.github.joaovitoreestevam.clinica.dto.medico.MedicoCadastroDTO;
import com.github.joaovitoreestevam.clinica.dto.medico.MedicoListagemDTO;
import com.github.joaovitoreestevam.clinica.models.medico.Medico;
import com.github.joaovitoreestevam.clinica.repositories.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository repository;

    @GetMapping
    public Page<MedicoListagemDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
      return repository.findAll(paginacao).map(MedicoListagemDTO::new);
    }

    @PostMapping
    public void cadastrar(@RequestBody @Valid MedicoCadastroDTO dto){
       Medico medico = new Medico(dto);

        repository.save(medico);
    }
}
