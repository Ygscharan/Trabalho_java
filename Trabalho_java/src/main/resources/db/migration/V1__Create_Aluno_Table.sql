CREATE TABLE aluno (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       nome VARCHAR(100) NOT NULL,
                       email VARCHAR(100) NOT NULL,
                       data_nascimento DATE NOT NULL
);
