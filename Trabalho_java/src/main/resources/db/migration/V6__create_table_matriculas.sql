CREATE TABLE matriculas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    aluno_id INT,
    professor_id INT,
    CONSTRAINT fk_aluno FOREIGN KEY (aluno_id) REFERENCES aluno(id),
    CONSTRAINT fk_professor FOREIGN KEY (professor_id) REFERENCES professores(id)
);


