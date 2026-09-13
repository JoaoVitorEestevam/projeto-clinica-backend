package com.github.joaovitoreestevam.clinica.controller.consulta;

import com.github.joaovitoreestevam.clinica.dto.consulta.ConsultaCadastroDTO;
import com.github.joaovitoreestevam.clinica.models.consulta.Consulta;
import com.github.joaovitoreestevam.clinica.models.consulta.validacoes.ValidadorAgendamentoConsulta;
import com.github.joaovitoreestevam.clinica.models.medico.Medico;
import com.github.joaovitoreestevam.clinica.models.paciente.Paciente;
import com.github.joaovitoreestevam.clinica.repositories.consulta.ConsultaRepository;
import com.github.joaovitoreestevam.clinica.repositories.medico.MedicoRepository;
import com.github.joaovitoreestevam.clinica.repositories.paciente.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    ConsultaRepository consultaRepository;

    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    List<ValidadorAgendamentoConsulta> validadores;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid ConsultaCadastroDTO dto){

        if(!medicoRepository.existsById(dto.medicoId())){
            throw new RuntimeException("o médico informado não existe no sistema");

        }

        if(!pacienteRepository.existsById(dto.pacienteId())){
            throw new RuntimeException("o paciente informado não existe no sistema");

        }

        Medico medico = medicoRepository.getReferenceById(dto.medicoId());
        if(!medico.getAtivo()){
            throw new RuntimeException("não é possível agendar uma consulta com um médico inativo");
        }

        Paciente paciente = pacienteRepository.getReferenceById(dto.pacienteId());
        if(!paciente.getAtivo()){
            throw new RuntimeException("não é possível agendar uma consulta com um paciente inativo");
        }

        validadores.forEach(v -> v.validar(dto));

        Consulta consulta = new Consulta();
        consulta.setMedico(medico);
        consulta.setPaciente(paciente);
        consulta.setDataHora(dto.data());

        consultaRepository.save(consulta);

    }
}
