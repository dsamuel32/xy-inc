# xy-inc

###Tecnologias Utilizadas
- Java EE utilizando EJB, JPA, JAX-RS
- Mysql
- Flyway
- Maven
- Wildfly 8
- Web Service Restful

### Instruções
- Entrar na pasta do projeto xy-inc-ejb e executar o comando:

```sh
mvn compile flyway:migrate
```

Para executar efetuar as criação do banco e adição dos dados iniciais do projeto.
- Criar o pool de conexão no Wildfly.
- Entrar na pasta xy-inc e executar o comando: 

```sh
mvn clean install
```

- Efetuar o deploy no Wildfly.

###Serviços disponibilizado

- Cadatrar
A requisião e feita via POST enviando um JSON com os dados a serem cadastrados.

Requisição:
```sh
Url: http://localhost:8080/xy-inc-web/resources/api/ponto-interesse
Method: POST
Content-Type: application/json;charset=utf-8
Body: {"nome":"Meu Local","coordenadaX":10,"coordenadaY":20}
```

Resposta:
```sh
Url: http://localhost:8080/xy-inc-web/resources/api/ponto-interesse
Method: POST
Content-Type: application/json;charset=utf-8
Body: {"id": 1, "nome":"Meu Local","coordenadaX":10,"coordenadaY":20}
```

- Listar todos

Requisição feita via GET sem informar nenhum parâmetro.

Requisição:
```sh
Url: http://localhost:8080/xy-inc-web/resources/api/ponto-interesse
Method: GET
```

Resporta:

```sh
Url: http://localhost:8080/xy-inc-web/resources/api/ponto-interesse
Method: GET
Content-Type: application/json;charset=utf-8
Body: [
       {"id": 1, "nome":"Meu Local 1","coordenadaX":10,"coordenadaY":20}, 
       {"id": 1, "nome":"Meu Local 2","coordenadaX":100,"coordenadaY":50}
      ]
```

- Listar Pontos Próximos

Requisição feita via GET informando os parâmetros:
- coordenadaX
- coordenadaY
- distanciaMaxima

Requisição:
```sh
Url: http://localhost:8080/xy-inc-web/resources/api/ponto-interesse/{coordenadaX}/{coordenadaY}/{distanciaMaxima}
Method: GET
```

Resporta:

```sh
Url: http://localhost:8080/xy-inc-web/resources/api/ponto-interesse
Method: GET
Content-Type: application/json;charset=utf-8
Body: [
       {"id": 1, "nome":"Local Próximo 1","coordenadaX":10,"coordenadaY":20}, 
       {"id": 1, "nome":"Local Próximo 2","coordenadaX":100,"coordenadaY":50}
      ]
```
