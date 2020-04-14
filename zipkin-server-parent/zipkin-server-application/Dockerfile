FROM openjdk:13-jdk-oracle
EXPOSE 9411
ADD target/zipkin-server.jar zipkin-server.jar
ENTRYPOINT ["sh", "-c", "java -jar /zipkin-server.jar"]
