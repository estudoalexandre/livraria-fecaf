create database livraria_fecaf;
use livraria_fecaf;

CREATE TABLE livros (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        titulo VARCHAR(255) NOT NULL,
                        autor VARCHAR(255) NOT NULL,
                        isbn VARCHAR(13) UNIQUE,
                        ano_publicacao INT,
                        editora VARCHAR(255),
                        categoria VARCHAR(100),
                        quantidade INT DEFAULT 0,
                        data_cadastro DATETIME DEFAULT CURRENT_TIMESTAMP,
                        status ENUM('disponível', 'emprestado', 'reservado') DEFAULT 'disponível'
);


INSERT INTO livros (titulo, autor, isbn, ano_publicacao, editora, categoria, quantidade, status)
VALUES
    ('Dom Quixote', 'Miguel de Cervantes', '9781234567890', 1605, 'Editora Clássica', 'Romance', 5, 'disponível'),
    ('O Morro dos Ventos Uivantes', 'Emily Brontë', '9780987654321', 1847, 'Editora Literária', 'Ficção', 3, 'emprestado'),
    ('1984', 'George Orwell', '9781122334455', 1949, 'Editora Nova', 'Distopia', 7, 'disponível'),
    ('Orgulho e Preconceito', 'Jane Austen', '9782233445566', 1813, 'Editora Literária', 'Romance', 4, 'reservado'),
    ('O Pequeno Príncipe', 'Antoine de Saint-Exupéry', '9783344556677', 1943, 'Editora Infantojuvenil', 'Infantil', 10, 'disponível'),
    ('Harry Potter e a Pedra Filosofal', 'J.K. Rowling', '9784455667788', 1997, 'Editora Fantasia', 'Fantasia', 6, 'emprestado');