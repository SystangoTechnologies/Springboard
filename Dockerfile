FROM tomcat:8.0.20-jre8
MAINTAINER Arpit Khandelwal <arpit@systango.com>
VOLUME /tmp
EXPOSE 8090
COPY target/springboard-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/app.war
RUN sh -c 'touch /usr/local/tomcat/webapps/app.war'
ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /usr/local/tomcat/webapps/app.war"]
