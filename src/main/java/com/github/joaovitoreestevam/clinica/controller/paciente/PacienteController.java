package com.github.joaovitoreestevam.clinica.controller.paciente;

import com.github.joaovitoreestevam.clinica.client.ViaCepClient;
import com.github.joaovitoreestevam.clinica.dto.endereco.ViaCepDTO;
import com.github.joaovitoreestevam.clinica.dto.paciente.PacienteAtualizacaoDTO;
import com.github.joaovitoreestevam.clinica.dto.paciente.PacienteCadastroDTO;
import com.github.joaovitoreestevam.clinica.dto.paciente.PacienteListagemDTO;
import com.github.joaovitoreestevam.clinica.models.endereco.Endereco;
import com.github.joaovitoreestevam.clinica.models.paciente.Paciente;
import com.github.joaovitoreestevam.clinica.repositories.PacienteRepository;
import jakarta.transaction.Transactional;
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

    @Autowired
    private ViaCepClient viaCepClient;
    @GetMapping
    public Page<PacienteListagemDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(PacienteListagemDTO::new);
    }

    @PostMapping
    public void cadastrar(@RequestBody @Valid PacienteCadastroDTO dto){
        ViaCepDTO dadosViaCep = viaCepClient.buscarEnderecoPorCep(dto.endereco().cep());

        Paciente paciente = new Paciente(dto);

        paciente.setEndereco(new Endereco(dto.endereco(), dadosViaCep));

        repository.save(paciente);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid PacienteAtualizacaoDTO dto){
        Paciente paciente = repository.getReferenceById(dto.id());

        paciente.atualizarInformacoes(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        Paciente paciente = repository.getReferenceById(id);

        paciente.excluir();
    }
}
