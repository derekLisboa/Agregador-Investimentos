💰 Agregador de Investimentos

API REST desenvolvida com Java e Spring Boot para gerenciamento de usuários em um sistema de agregação de investimentos.

O projeto foi criado com foco em boas práticas de desenvolvimento, organização em camadas e integração com banco de dados relacional.
------------------------------------------------------------------------------------------------------------------------------------------------

🚀 Tecnologias Utilizadas

Java 21

Spring Boot 3

Spring Web

Spring Data JPA

Hibernate

MySQL

Maven

Docker Compose

---

🏗️ Arquitetura

O projeto segue o padrão de arquitetura em camadas:

Controller → Responsável pelos endpoints REST

Service → Contém as regras de negócio

Repository → Interface JPA para acesso ao banco de dados

Entity → Representação das tabelas no banco

DTO → Objetos utilizados para entrada de dados

Essa organização facilita manutenção, testes e escalabilidade do sistema.

---

📌 Funcionalidades

Criar usuário

Listar usuários

Buscar usuário por ID

Atualizar usuário

Deletar usuário

---

📮 Endpoints

POST /users → Criar usuário

GET /users → Listar usuários

GET /users/{id} → Buscar usuário por ID

PUT /users/{id} → Atualizar usuário

DELETE /users/{id} → Deletar usuário

---

🗄️ Banco de Dados

O projeto utiliza MySQL, podendo ser executado facilmente com Docker Compose.

---

▶️ Como Executar o Projeto

Clone o repositório:

git clone https://github.com/derekLisboa/Agregador-Investimentos.git

Suba o banco de dados com Docker:

docker-compose up -d

Execute a aplicação:

./mvnw spring-boot:run

A API estará disponível em:

http://localhost:8080

---

🎯 Objetivo do Projeto

Projeto desenvolvido para praticar a construção de APIs REST com Spring Boot, aplicando boas práticas de arquitetura, uso de DTOs e integração com banco de dados relacional.
