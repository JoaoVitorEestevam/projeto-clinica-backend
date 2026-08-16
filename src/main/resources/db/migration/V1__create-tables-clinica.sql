CREATE TABLE medicos
(
    id            BIGSERIAL PRIMARY KEY ,
    nome          VARCHAR(100) NOT NULL ,
    email         VARCHAR(100),
    telefone      VARCHAR(20),
    crm           VARCHAR(20)  NOT NULL UNIQUE ,
    especialidade VARCHAR(50)  NOT NULL
);

CREATE TABLE pacientes
(
    id         BIGSERIAL PRIMARY KEY,
    nome       VARCHAR(100) NOT NULL,
    email      VARCHAR(100),
    telefone   VARCHAR(20),
    cpf        VARCHAR(14)  NOT NULL UNIQUE,
    cep        VARCHAR(9)   NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    bairro     VARCHAR(50)  NOT NULL,
    cidade     VARCHAR(50)  NOT NULL,
    uf         VARCHAR(2)   NOT NULL,
    numero     VARCHAR(20)
);

CREATE TABLE consultas
(
    id                  BIGSERIAL PRIMARY KEY,
    data_hora           TIMESTAMP NOT NULL ,
    status              VARCHAR(20) NOT NULL,
    motivo_cancelamento VARCHAR(50),
    medico_id           BIGINT      NOT NULL,
    paciente_id         BIGINT      NOT NULL,

    CONSTRAINT fk_consultas_medico_id FOREIGN KEY (medico_id) REFERENCES medicos (id),
    CONSTRAINT fk_consultas_paciente_id FOREIGN KEY (paciente_id) REFERENCES pacientes (id)
);