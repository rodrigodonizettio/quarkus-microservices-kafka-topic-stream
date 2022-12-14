# worker-kafka-producer Project

This application produces data to "pokemon-appear" and "pokemon-appear-avro" Kafka Topics.

The following request produces a String message to the topic:
```
curl -X POST http://localhost:8080/pokemon/appear
```

## Generating the Pokemon Java AVRO Schema based:
```
./mvnw clean package
```
The file will be available in **target/generated-sources/avsc**

## Producing a Pokemon AVRO message to the topic:
```
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"uuid":"a01ca9c9-23e2-4045-9b17-779a09289746","name":"Charmander", "height":6,"weight":85}' \
  http://localhost:8080/pokemon/appear-avro
```

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/worker-kafka-producer-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- SmallRye Reactive Messaging - Kafka Connector ([guide](https://quarkus.io/guides/kafka-reactive-getting-started)): Connect to Kafka with Reactive Messaging
