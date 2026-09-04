package com.github.joaovitoreestevam.clinica.models.paciente;
import com.github.joaovitoreestevam.clinica.dto.paciente.PacienteAtualizacaoDTO;
import com.github.joaovitoreestevam.clinica.dto.paciente.PacienteCadastroDTO;
import com.github.joaovitoreestevam.clinica.models.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity(name = "Paciente")
@Table(name = "pacientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    private String email;

    private String telefone;

    @NotBlank
    @Column(unique = true)
    private String cpf;

    @Embedded
    @NotNull
    private Endereco endereco;

    @NotNull
    private Boolean ativo = true;

    public void excluir(){
        this.ativo = false;
    }

    public Paciente(PacienteCadastroDTO dto){
        this.nome = dto.nome();
        this.email = dto.email();
        this.telefone= dto.telefone();
        this.cpf = dto.cpf();
        this.endereco = new Endereco(dto.endereco());
    }

    public void atualizarInformacoes(PacienteAtualizacaoDTO dto){
        if (dto.nome() != null){
            this.nome = dto.nome();
        }

        if (dto.email() != null){
            this.email = dto.email();
        }

        if (dto.telefone() != null){
            this.telefone = dto.telefone();
        }

        if (dto.endereco() != null){
            this.endereco.atualizarInformacoes(dto.endereco());
        }
    }
}
