FROM openjdk:11-jre-slim
EXPOSE 8760
ADD target/admin-server.jar admin-server.jar
ENTRYPOINT ["sh", "-c", "java -jar /admin-server.jar"]
