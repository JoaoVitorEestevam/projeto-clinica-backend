package com.github.joaovitoreestevam.clinica.models.paciente;
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
}
