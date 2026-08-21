package com.github.joaovitoreestevam.clinica.models.medico;

import com.github.joaovitoreestevam.clinica.dto.medico.MedicoCadastroDTO;
import com.github.joaovitoreestevam.clinica.models.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Entity(name = "Medico")
@Table(name = "medicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    private String email;

    private String telefone;

    @NotBlank
    @Column(unique = true)
    private String crm;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Especialidades especialidade;

    @NotNull
    @Embedded
    private Endereco endereco;


    public Medico(MedicoCadastroDTO dto){
        this.nome = dto.nome();
        this.email = dto.email();
        this.telefone = dto.telefone();
        this.crm = dto.crm();
        this.especialidade = dto.especialidade();
        this.endereco = new Endereco(dto.endereco());
    }
}
