# Transfer CVC

# Tecnologias

- Java 18
- Spring Boot
- Lombok
- Intellij
- Maven
- H2
- Flyway
- Docker
- Heroku

# Arquitetura

Optei por fazer uma arquitetura mais simples, assim como faria no dia a dia se tivesse apenas uma api ou serviço. Usei uma controller, service e repository. Optei por usar o flyway para ter registros das possíveis alterações de banco de dados. Mesmo com a complexidade dos vários ifs, não quis usar nenhum padrão de projeto como o strategy, pois no fim teria que fazer os ifs do mesmo jeito, só que em arquivos separados, aumentando a complexidade do código e dificultando o entendendimento.

# Banco de dados

Por se tratar de uma api de teste, usei o H2. Não é preciso instalar banco de dados local para a aplicação funcionar.


# Heroku

Caso queira acessar a aplicação, clique no link abaixo:

```
https://cvc-test.herokuapp.com/swagger-ui/index.html#/
```

# Como usar

Acessando o Swagger verá que temos duas API's, um POST e um GET com o mapping "/transfer"

Se acessar o POST no caminho abaixo
```
https://cvc-test.herokuapp.com/transfer
```

Com o body 
```
{
  "amount": 200,
  "transferAt": "2022-05-31",
  "accountOrigin": "123456",
  "account": "1234567"
}
```

Terá o resultado

```
{
  "id": 1,
  "amount": 200,
  "feeAmount": 9,
  "type": "SAME_DAY",
  "createdAt": "2022-05-31",
  "transferAt": "2022-05-31",
  "accountOrigin": "123456",
  "accountDestination": "1234567"
}
```

Usando o cUrl abaixo terá o mesmo resultado.

```
curl -X 'POST' \
  'https://cvc-test.herokuapp.com/transfer' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "amount": 200,
  "transferAt": "2022-05-31",
  "accountOrigin": "123456",
  "account": "1234567"
}'

```


Se acessar via GET no caminho abaixo, terá os registros em lista.
```
https://cvc-test.herokuapp.com/transfer
```

```
[
  {
    "id": 1,
    "amount": 200,
    "feeAmount": 9,
    "type": "SAME_DAY",
    "createdAt": "2022-05-31",
    "transferAt": "2022-05-31",
    "accountOrigin": "123456",
    "accountDestination": "1234567"
  }
]
```



# Build - Maven

Dentro do diretório raíz da aplicacao, execute o comando abaixo:

```
$ mvn clean install -DskipTests=true

```

## Run Maven

Dentro do diretório raíz da aplicacao, execute o comando abaixo:

```
$ mvn spring-boot:run

```

## Executando os testes

Para executar os testes, basta executar o comando abaixo dentro do diretório da aplicação:

```
$ mvn test

```

## Executando a aplicação

Com a aplicação rodando, vá ao navegador e digite:

http://localhost:8080/swagger-ui.html#/




# Build Docker

Dentro do diretório raiz da aplicação, execute o comando abaixo:

```
$ mvn clean install -DskipTests=true

```

Precisamos dessa etapa pra poder ter o jar do projeto.

Dentro ainda do diretório, digite o comando abaixo:


```

$ docker build -t transfer.jar .

```


Se tudo correr bem, você terá uma imagem docker pronto pra ser executada.

Para confirmar que gerou, rode o comando abaixo:


```

$ docker image ls

```



## Run Docker

Para executar a aplicação, basta fazer um docker run conforme abaixo.


```

$ docker run -p 8080:8080 transfer.jar 

```


## Executando a aplicação Docker

Depois do run, vá no navegador e digite


```

http://localhost:8080/swagger-ui.html#/ 

```
