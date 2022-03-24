## Backend HMV do APP Mobile

## Obrigatório 

Para o build e rodar a aplicação são necessários:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Rodando a aplicação local

A várias maneiras de rodar o Spring Boot na sua máquina local. Uma forma facil é executar o 'main' método na classe de inicialização do Spring Boot
Application na sua IDE.


Outra alternativa é utilizando o Maven [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html):

```
mvn spring-boot:run
```

## Documentação
Assim que for executado a aplicação, ela vai subir na porta padrão 8080, e ao abrir no navegador (localhost:8080) você será redirecionado para o Swagger, um framework composto por diversas ferramentas que, independente da linguagem, auxilia a descrição, consumo e visualização de serviços de uma API REST, uma forma facil de visualizar as rotas e contratos da nossa API REST.

