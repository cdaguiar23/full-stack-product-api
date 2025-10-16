--liquibase formatted sql

INSERT INTO produtos (nome, descricao, responsavel, data_criacao, data_modificacao, tipo_categoria) VALUES
('Notebook Dell', 'Notebook para desenvolvimento', 'João Silva', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Eletrônicos'),
('Mouse Logitech', 'Mouse óptico sem fio', 'Maria Oliveira', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Acessórios'),
('Monitor Samsung', 'Monitor 24 polegadas Full HD', 'Carlos Santos', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Eletrônicos'),
('Teclado Mecânico', 'Teclado mecânico RGB', 'Ana Costa', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Acessórios'),
('Impressora HP', 'Impressora multifuncional', 'Pedro Lima', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Periféricos'),
('Smartphone Xiaomi', 'Smartphone Android 128GB', 'Luana Ferreira', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Eletrônicos'),
('Fone de Ouvido Sony', 'Fone de ouvido com cancelamento de ruído', 'Roberto Almeida', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Acessórios'),
('Tablet Apple', 'Tablet iPad Pro 11 polegadas', 'Fernanda Rocha', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Eletrônicos'),
('HD Externo Seagate', 'HD externo 1TB USB 3.0', 'Gustavo Pereira', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Armazenamento'),
('Webcam Logitech', 'Webcam HD para videochamadas', 'Juliana Mendes', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Periféricos');
