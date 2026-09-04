package com.github.joaovitoreestevam.clinica.controller.medico;


import com.github.joaovitoreestevam.clinica.client.ViaCepClient;
import com.github.joaovitoreestevam.clinica.dto.endereco.ViaCepDTO;
import com.github.joaovitoreestevam.clinica.dto.medico.MedicoAtualizacaoDTO;
import com.github.joaovitoreestevam.clinica.dto.medico.MedicoCadastroDTO;
import com.github.joaovitoreestevam.clinica.dto.medico.MedicoListagemDTO;
import com.github.joaovitoreestevam.clinica.models.endereco.Endereco;
import com.github.joaovitoreestevam.clinica.models.medico.Medico;
import com.github.joaovitoreestevam.clinica.repositories.MedicoRepository;
import jakarta.transaction.Transactional;
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

    @Autowired
    private ViaCepClient viaCepClient;
    @GetMapping
    public Page<MedicoListagemDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
      return repository.findAll(paginacao).map(MedicoListagemDTO::new);
    }

    @PostMapping
    public void cadastrar(@RequestBody @Valid MedicoCadastroDTO dto){

       ViaCepDTO dadosViaCep = viaCepClient.buscarEnderecoPorCep(dto.endereco().cep());

       Medico medico = new Medico(dto);

       medico.setEndereco(new Endereco(dto.endereco(), dadosViaCep));

        repository.save(medico);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid MedicoAtualizacaoDTO dto){
        Medico medico = repository.getReferenceById(dto.id());

        medico.atualizarInformacoes(dto);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void exlcuir(@PathVariable Long id){
        Medico medico = repository.getReferenceById(id);

        medico.excluir();
    }
}
