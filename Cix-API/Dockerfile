FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/cix-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=production","-jar","app.jar"]