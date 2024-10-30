CREATE TABLE produtos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_produto VARCHAR(255) NOT NULL,
    marca VARCHAR(255) NOT NULL,
    data_fabricacao DATE NOT NULL,
    data_validade DATE,
    genero VARCHAR(100) NOT NULL,
    lote VARCHAR(100) NOT NULL,
    ativo BOOLEAN DEFAULT TRUE
);