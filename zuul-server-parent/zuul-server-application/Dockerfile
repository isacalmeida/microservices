FROM openjdk:13-jdk-oracle
EXPOSE 8765
ADD target/zuul-server.jar zuul-server.jar
ENTRYPOINT ["sh", "-c", "java -jar /zuul-server.jar"]
