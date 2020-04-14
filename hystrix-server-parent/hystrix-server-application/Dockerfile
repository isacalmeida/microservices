FROM openjdk:13-jdk-oracle
EXPOSE 8769
ADD target/hystrix-server.jar hystrix-server.jar
ENTRYPOINT ["sh", "-c", "java -jar /hystrix-server.jar"]
