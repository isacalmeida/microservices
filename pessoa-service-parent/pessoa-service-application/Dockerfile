FROM openjdk:13-jdk-oracle
EXPOSE 8000
ADD target/pessoa-service.jar pessoa-service.jar
ENTRYPOINT ["sh", "-c", "java -jar /pessoa-service.jar"]
