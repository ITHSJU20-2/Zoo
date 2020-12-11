FROM maven:3.6.0-jdk-11-slim AS maven
COPY src /src
COPY pom.xml /
RUN mvn -f pom.xml clean package
FROM payara/server-full
COPY --from=maven target/ZooGame.war /opt/payara/deployments/zoo-game.war