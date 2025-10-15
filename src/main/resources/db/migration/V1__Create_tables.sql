CREATE TABLE IF NOT EXISTS produtos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    responsavel VARCHAR(255),
    data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_modificacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    tipo_categoria VARCHAR(100),
    ativo BOOLEAN NOT NULL DEFAULT true,
    CONSTRAINT uk_nome UNIQUE (nome),
    CONSTRAINT chk_nome_not_empty CHECK (nome != '')
);