CREATE TABLE cursos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    codigo VARCHAR(20) NOT NULL UNIQUE,
    carga_horaria INT NOT NULL
);

CREATE TABLE turmas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ano INT NOT NULL,
    semestre INT NOT NULL CHECK (semestre IN (1, 2)),
    curso_id INT NOT NULL,
    FOREIGN KEY (curso_id) REFERENCES cursos(id)
);
