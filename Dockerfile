FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package
FROM payara/server-full
COPY target/ZooGame.war /opt/payara/development/zoo-game.war
