FROM openjdk:11.0.3-jdk-stretch

WORKDIR /neo4j/myapp

ADD ./target/neo4j-demo-0.0.1-SNAPSHOT.jar   /neo4j/myapp/neo4j-demo-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","neo4j-demo-0.0.1-SNAPSHOT.jar"]