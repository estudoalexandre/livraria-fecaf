# Minha Biblioteca

Este é um projeto simples de gerenciamento de livros desenvolvido usando **Spring Boot** e **Thymeleaf**, com integração ao banco de dados e funcionalidades básicas como cadastro, edição, exclusão, e listagem de livros em formato de cartões (cards).

## Funcionalidades

- **Cadastrar Livros**: Adicione novos livros com informações como título, autor, categoria, status, e imagem.
- **Listar Livros**: Visualize todos os livros cadastrados com paginação e barra de busca.
- **Editar Livros**: Atualize os detalhes de um livro existente.
- **Excluir Livros**: Remova livros do sistema.
- **Ordenação Alfabética**: Os livros são exibidos em ordem alfabética pelo título.

## Tecnologias Utilizadas

### Back-end
- **Java**
- **Spring Boot**
  - Spring MVC
  - Spring Data JPA
- **Hibernate**

### Front-end
- **Thymeleaf**
- **Bootstrap 5**
- **JavaScript**
  - jQuery

### Banco de Dados
- **MySQL**

### Outros
- Maven para gerenciamento de dependências.

## Como Rodar o Projeto

### Pré-requisitos

- **Java 17** ou superior
- **Maven**
- **MySQL**
- Um IDE como **IntelliJ IDEA**

### Configuração

1. Clone o repositório:
   ```bash
   git clone https://github.com/estudoalexandre/livraria-fecaf.git
   cd livraria-fecaf
   ```

2. Configure o banco de dados no arquivo `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/minha_biblioteca
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
   ```

3. Instale as dependências e compile o projeto:
   ```bash
   mvn clean install
   ```

4. Execute o projeto:
   ```bash
   mvn spring-boot:run
   ```

5. Acesse a aplicação no navegador:
   ```
   http://localhost:8080
   ```

### Estrutura de Pastas

```
.
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── br.com.fecaf
│   │   │   │   ├── App.java # Iniciando do App
│   │   │   │   ├── controller   # Controladores Spring MVC
│   │   │   │   ├── database   # model para o Banco de dados
│   │   │   │   ├── model        # Modelos JPA
│   │   │   │   ├── repository   # Repositórios Spring Data
│   │   │   │   └── services     # Lógica de negócios
│   │   ├── resources
│   │   │   ├── static           # Arquivos CSS, JS, imagens
│   │   │   ├── templates        # Templates Thymeleaf
│   │   │   └── application.properties
├── pom.xml
└── README.md
```

## Endpoints Principais

### Livros
- **Listar Livros**: `GET /livros/listarLivros`
- **Cadastrar Livro**: `GET /livros/cadastrarLivro`
- **Salvar Livro**: `POST /livros/cadastrarLivro`
- **Editar Livro**: `GET /livros/editarLivro/{id}`
- **Excluir Livro**: `POST /livros/deletar`

## Funcionalidades Futuras

- Adicionar autenticação e autorização para diferentes usuários.
- Melhorar o design da interface com novos recursos visuais.
- Implementar upload de imagem para livros diretamente no formulário.


## Licença

Este projeto é de uso livre e aberto para aprendizado e evolução pessoal/profissional.

---
Criado por [Alexandre Oliveira]
