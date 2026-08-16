package com.github.joaovitoreestevam.clinica.models.medico;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


public enum Especialidades {
    ORTOPEDIA, GINECOLOGIA, NEUROLOGIA, PEDIATRIA, DERMATOLOGIA, OFTALMOLOGIA, ONCOLOGIA, ENDOCRINOLOGIA
}
