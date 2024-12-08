# ecommerce


## Requisitos

- Docker e Docker Compose devem estar instalados.
- Java 21 deve estar instalado.

Não é necessário iniciar manualmente o Docker Compose deste projeto antes de executar a aplicação. Estamos utilizando a integração nativa fornecida pelo **Spring Boot Docker Compose**, o que significa que a própria aplicação Spring Boot executará o comando `docker compose up`.

Isso criará os contêineres definidos no arquivo de configuração, como o `compose.yml` ou `docker-compose.yml`, automaticamente durante a inicialização da aplicação.
