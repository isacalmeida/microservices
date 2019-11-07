FROM openjdk:13-jdk-oracle
EXPOSE 8888
ADD target/config-server.jar config-server.jar
ENTRYPOINT ["sh", "-c", "java -jar /config-server.jar"]
