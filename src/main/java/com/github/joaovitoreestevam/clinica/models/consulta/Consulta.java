package com.github.joaovitoreestevam.clinica.models.consulta;

import com.github.joaovitoreestevam.clinica.models.medico.Medico;
import com.github.joaovitoreestevam.clinica.models.paciente.Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

 enum Status{
    AGENDADA, CANCELADA
}

enum MotivoCancelamento{
     PACIENTE_CANCELOU, MEDICO_CANCELOU, OUTROS
}


@Entity(name = "Consulta")
@Table(name = "consultas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(name = "motivo_cancelamento")
    private MotivoCancelamento motivoCancelamento;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;


}
