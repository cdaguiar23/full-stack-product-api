--liquibase formatted sql

CREATE TABLE produtos (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    responsavel VARCHAR(255),
    data_criacao TIMESTAMP NOT NULL,
    data_modificacao TIMESTAMP,
    tipo_categoria VARCHAR(255)
);
