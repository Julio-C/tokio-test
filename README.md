# Custumer Service

### Requisitos

1. JDK 8
1. Maven 3

### Rodando

1. Clone o projeto: `https://github.com/leonardohenrique/tokio-test.git`
1. Entre na pasta `tokio-test` e execute: `mvn spring-boot:run`
1. Acesse: `http://localhost:8080/customers`

Tokio-Teste

Heroku : https://tokio-teste.herokuapp.com/swagger-ui.html

endpoints Postman

GET  (List) =  https://tokio-teste.herokuapp.com/customers
POST (Create) =  https://tokio-teste.herokuapp.com/customers
          endpoint:
                  {
                     "email": "julio@teste.com",
                     "name": "julio"
                  }

PUT (Update) =  https://tokio-teste.herokuapp.com/customers
        endpoint:
                  {
                     "id":3,
                     "email": "julio@teste.com",
                     "name": "julio"
                  }
                 
DELETE   =    https://tokio-teste.herokuapp.com/customers/3

GET (FindById) =    https://tokio-teste.herokuapp.com/customers/3
