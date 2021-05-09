## Instruções

### Criar rede docker:

```
docker network create folha-net
```

### Criando imagem Postgresql no Docker:

```
docker run -p 5432:5432 --name db-postgres --network folha-net -e POSTGRES_PASSWORD=root -e POSTGRES_DB=dbfuncionario postgres:12-alpine
docker run --name pgadmin --network folha-net -p 15432:80 -e "PGADMIN_DEFAULT_EMAIL=rivaildo@yahoo.com.br" -e "PGADMIN_DEFAULT_PASSWORD=123456" -d dpage/pgadmin4
```

### Criando imagem Redis no Docker:

```
docker run -p 6379:6379 --name db-redis --network folha-net redis
docker exec -it db-redis redis-cli
```

### Criando imagem Mongo no Docker:

```
docker run -p 27017:27017 --name db-mongo --network folha-net -e MONGO_INITDB_ROOT_USERNAME=root -e MONGO_INITDB_ROOT_PASSWORD=e296cd9f mongo
docker run -it --rm --network folha-net mongo mongo --host db-mongo -u root -p e296cd9f --authenticationDatabase admin dbpagamento
```

### Criando imagem Kafka no Docker:

```
docker run -d --name zookeeper-server --network folha-net -e ALLOW_ANONYMOUS_LOGIN=yes bitnami/zookeeper:latest
docker run -d --name kafka-server --network folha-net -e ALLOW_PLAINTEXT_LISTENER=yes -e KAFKA_CFG_ZOOKEEPER_CONNECT=zookeeper-server:2181 bitnami/kafka:latest
docker run -it --rm --network folha-net -e KAFKA_CFG_ZOOKEEPER_CONNECT=zookeeper-server:2181 bitnami/kafka:latest kafka-topics.sh --list  --zookeeper zookeeper-server:2181
```

### Criando imagem Eureka no Docker:

```
mvn clean install -DskipTests
docker build -t eureka-server:v1 .
docker run -p 8761:8761 --name container-eureka-server --network folha-net eureka-server:v1
```

### Criando imagem gateway no Docker:

```
mvn clean install -DskipTests
docker build -t api-gateway:v1 .
docker run -p 9090:9090 --name container-api-gateway --network folha-net api-gateway:v1
```

### Criando imagem Spring boot admin no Docker:

```
mvn clean install -DskipTests
docker build -t spring-boot-admin:v1 .
docker run -p 8081:8081 --name container-spring-boot-admin --network folha-net spring-boot-admin:v1
```

### Criando imagem Funcionario no Docker:

```
mvn clean install -DskipTests
docker build -t funcionario:v1 .
docker run -P --network folha-net funcionario:v1
```

### Criando imagem Calculo no Docker:

```
mvn clean install -DskipTests
docker build -t calculo:v1 .
docker run -P --network folha-net calculo:v1
```

### Criando imagem Pagamento no Docker:

```
mvn clean install -DskipTests
docker build -t pagamento:v1 .
docker run -P --network folha-net pagamento:v1
```
