FROM eclipse-temurin:11-jdk
#FROM openjdk:11
#FROM openjdk:11-jdk
#VOLUME /tmp
ARG JAR_FILE=./build/libs/jenkins-test-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080


#FROM openjdk:17-ea-11-jdk-slim
#
#VOLUME /tmp
#
#ARG JAR_FILE=build/libs/jenkins-test-0.0.1-SNAPSHOT.jar
#
#COPY ${JAR_FILE} jenkins-test.jar
#
##COPY build/libs/server-0.0.1-SNAPSHOT.jar Server.jar
#
#ENTRYPOINT ["java","-jar","/jenkins-test.jar"]
#
#EXPOSE 8080
