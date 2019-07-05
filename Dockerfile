FROM openjdk:11-jre-slim
COPY build/libs/kotlin-starter.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
