Finance API

https://finace-api-production.up.railway.app

API REST de controle financeiro desenvolvida com Java e Spring Boot.

Tecnologias

Backend
- Java 17
- Spring Boot 3.4.4
- Spring Data JPA
- Spring Web

Banco de dados
- MySQL

Infraestrutura
- Docker
- Docker Compose

Ferramenta de testes
- Postman

Funcionalidades

- Cadastro de receitas e despesas
- Listagem de todas as transações
- Filtro por tipo (receitas ou despesas)
- Cálculo automático de saldo total

Endpoints

- GET /api/transacoes - lista todas as transações
- GET /api/transacoes/saldo - retorna receitas, despesas e saldo total
- GET /api/transacoes/receitas - lista apenas receitas
- GET /api/transacoes/despesas - lista apenas despesas
- POST /api/transacoes - cadastra nova transação
- DELETE /api/transacoes/{id} - remove transação

Como rodar o projeto

Opção 1 - Com Docker (recomendado)

Pré-requisitos
- Docker
- Docker Compose

Comando

docker-compose up --build

A aplicação sobe automaticamente com o banco de dados MySQL incluso.
Acesse em: http://localhost:8080

Opção 2 - Sem Docker

Pré-requisitos
- Java 17+
- Maven
- MySQL

Configuração do banco de dados

No MySQL execute:

CREATE DATABASE finance_db;

Configuração do application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/finance_db
spring.datasource.username=root
spring.datasource.password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

Rodando o projeto

git clone https://github.com/PabloGomes22/finace-api.git
cd finace-api
./mvnw spring-boot:run

Acesse em: http://localhost:8080

Exemplo de uso

Cadastrar uma receita

POST /api/transacoes

{
    "descricao": "Salário",
    "valor": 3000.00,
    "tipo": "RECEITA",
    "categoria": "Trabalho",
    "data": "2026-05-25"
}

Cadastrar uma despesa

POST /api/transacoes

{
    "descricao": "Aluguel",
    "valor": 1200.00,
    "tipo": "DESPESA",
    "categoria": "Moradia",
    "data": "2026-05-25"
}

Consultar saldo

GET /api/transacoes/saldo

Resposta:

{
    "receitas": 3000.00,
    "despesas": 1200.00,
    "saldo": 1800.00
}

Autor

Feito por Pablo Gomes
https://github.com/PabloGomes22
