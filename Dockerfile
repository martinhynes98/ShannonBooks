#Dockerfile
#
# Build stage
#
FROM maven:3.8.2-openjdk-16-slim AS build
COPY online/src /home/app/src
COPY online/pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:16-slim
COPY --from=build /home/app/target/*.jar /usr/local/lib/app.jar
COPY online/sqlitesample.db /sqlitesample.db
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]