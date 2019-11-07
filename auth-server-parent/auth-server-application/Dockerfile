FROM openjdk:13-jdk-oracle
EXPOSE 8762
ADD target/auth-server.jar auth-server.jar
ENTRYPOINT ["sh", "-c", "java -jar /auth-server.jar"]
