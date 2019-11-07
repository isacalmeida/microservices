FROM openjdk:13-jdk-oracle
EXPOSE 8100
ADD target/acesso-service.jar acesso-service.jar
ENTRYPOINT ["sh", "-c", "java -jar /acesso-service.jar"]
