# E-commerce

## Sobre o Projeto

Este projeto é uma aplicação de e-commerce desenvolvida para fins de estudo. Ele implementa funcionalidades comuns de um sistema de pedidos, como:

- Cadastro de pedidos
- Listagem com paginação
- Detalhamento completo dos pedidos

Além disso, foi utilizado um modelo de dados rico com mapeamentos e estratégias avançadas do JPA/Hibernate.

## Funcionalidades

- Relacionamentos com JPA:
    - `@OneToOne`, `@OneToMany`, `@ManyToOne` e `@ManyToMany`
    - `@Embeddable` e `@EmbeddedId`
    - `@JoinColumn` e `@JoinTable` com `@UniqueConstraint`
- Estratégias de carregamento (Lazy/Eager)
- Diferentes estratégias de **Cascade**

## Tecnologias Usadas

- **Java 21**
- **Spring Boot**
- **Hibernate/JPA**
- **Docker e Docker Compose**
- Banco de dados PostgreSQL (configurável via Docker Compose)

Não é necessário iniciar manualmente o Docker Compose deste projeto antes de executar a aplicação. Estamos utilizando a integração nativa fornecida pelo **Spring Boot Docker Compose**, o que significa que a própria aplicação Spring Boot executará o comando `docker compose up`.

Isso criará os contêineres definidos no arquivo de configuração, como o `compose.yml` ou `docker-compose.yml`, automaticamente durante a inicialização da aplicação.

## Requisitos

Antes de começar, certifique-se de ter as seguintes ferramentas instaladas:

- [**Docker**](https://docs.docker.com/get-docker/) e [**Docker Compose**](https://docs.docker.com/compose/install/)
- [**Java 21**](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
- [**Git**](https://git-scm.com/)

> **Nota**: Não é necessário iniciar manualmente o Docker Compose. A aplicação Spring Boot usa a integração nativa do **Spring Boot Docker Compose** para iniciar os contêineres automaticamente durante a inicialização.

## Como executar o projeto

1. Clone o repositório:
```bash
git clone git@github.com:johnenderson/ecommerce.git
cd ecommerce
```
2. Inicie a aplicação:
```bash
./mvnw spring-boot:run
```

**Configurações adicionais:**

- Alterar porta: Para rodar em outra porta:
```bash
./mvnw spring-boot:run -Dspring-boot.run.arguments="--server.port=9090"
```
- Banco de Dados: O banco de dados será iniciado automaticamente com as configurações do Docker Compose. Confira o arquivo docker-compose.yml para detalhes.



