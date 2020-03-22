FROM openjdk:13-jdk-oracle
EXPOSE 8760
ADD target/admin-server.jar admin-server.jar
ENTRYPOINT ["sh", "-c", "java -jar /admin-server.jar"]
