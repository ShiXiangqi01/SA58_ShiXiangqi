FROM openjdk:17-jdk-slim
VOLUME /tmp
ADD ./target/MiniCoins-0.0.1-SNAPSHOT.jar rest.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "rest.jar"]