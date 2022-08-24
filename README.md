# quarkus-microservices-kafka-topic-stream
Maven Project using Quarkus producer and consumer microservices that communicate using Kafka.

Before use **docker-compose.yaml** file you must build both consumer and producer applications. Run the command:
```shell script
./mvnw -f worker-kafka-consumer|producer package
```