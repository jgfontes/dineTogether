# 🍽️ Dine Together

## 📌 Descrição

O **Dine Together** é um sistema de gestão colaborativo para restaurantes.  
A ideia é oferecer uma solução única e acessível, onde clientes podem consultar informações, deixar avaliações e realizar pedidos online, enquanto restaurantes conseguem gerenciar suas operações de forma centralizada.

Este projeto faz parte do **Tech Challenge - Fase 01 (FIAP)** e será desenvolvido em **Spring Boot**, seguindo boas práticas de arquitetura e qualidade de código.

---

## ❓ Perguntas Abertas
- Qual versão do **Java** deveremos usar no projeto?
- Vamos escrever o código em **português ou inglês**?
- Qual banco de dados vamos usar? **MySQL** ou **PostgreSQL**?
    - Faz sentido usar **H2** apenas para começar o desenvolvimento local?
- Onde vamos hospedar o **repositório**?
- Vamos trabalhar com **PRs e revisão de código**?

---

## ✅ TODO List

### 1. Preparação do Projeto
- [ ] Criar o repositório no GitHub/GitLab.
- [ ] Inicializar o projeto Spring Boot (Spring Initializr).
    - Dependências: **Spring Web**, **Spring Data JPA**, **Validation**, **Lombok**, **Springdoc OpenAPI/Swagger**.
- [ ] Configurar `.gitignore` (Java, Maven/Gradle, IDE).
- [ ] Escrever um README inicial com nome e objetivo do projeto.

### 2. Modelagem e Arquitetura
- [ ] Definir entidades principais (Usuário, Endereço, etc.).
- [ ] Definir tipos de usuários (`enum` ou herança → Cliente, Dono de Restaurante).
- [ ] Mapear os relacionamentos no banco.
- [ ] Esboçar o diagrama ER (entidades + relacionamentos).
- [ ] Definir a arquitetura em camadas (Controller, Service, Repository, DTOs).

### 3. Banco de Dados
- [ ] Escolher entre PostgreSQL ou MySQL.
- [ ] Configurar `application.properties` (ou `application.yml`).
- [ ] Criar `docker-compose.yml` com:
    - Container do banco de dados.
    - Container da aplicação.
- [ ] Testar conexão local (`docker-compose up`).

### 4. Funcionalidades Obrigatórias
- [ ] Cadastro de usuários (`POST /api/v1/users`).
- [ ] Validação de e-mail único.
- [ ] Busca por nome (`GET /api/v1/users?name=xxx`).
- [ ] Atualização de dados do usuário (sem senha) (`PUT /api/v1/users/{id}`).
- [ ] Troca de senha (`PATCH /api/v1/users/{id}/password`).
- [ ] Registro da data da última alteração (atualizar em cada mudança).
- [ ]
