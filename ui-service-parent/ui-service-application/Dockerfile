FROM tomcat:9.0.27-jdk13-openjdk-oracle
EXPOSE 9000
RUN rm -rf /usr/local/tomcat/webapps/*
COPY target/*.war /user/local/tomcat/webapps/ROOT.war
CMD ["catalina.sh","run"]