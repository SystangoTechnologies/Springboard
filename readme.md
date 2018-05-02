![Springboard](https://github.com/SystangoTechnologies/Springboard/blob/master/src/main/resources/static/img/springboard-logo.jpg)

## Springboard
Production ready maven based Spring Boot starter kit application.

## Description
Starter kit for jump starting the development of a API oriented spring based Java server. It contains the best practices and latest tools that a spring boot developer should opt for in a fresh development. Since JPA is used, developers are free to opt for any SQL based DB engine for persistence (Postgres has been used as an example with this code sample). The preferred IDE for development is IntelliJ which comes with a plethora of useful JAVA tools to support Spring Boot development, but devlopers are free to opt for Eclipse or STS as well.

## Technology

- **Spring Boot**     - Server side framework
- **JPA**             - Entity framework
- **Lombok**          - Provides automated getter/setters
- **Actuator**        - Application insights on the fly
- **Spring Security** - Spring's security layer
- **Thymeleaf**       - Template Engine
- **Devtools**        - Support Hot-Code Swapping with live browser reload
- **JJWT**            - JWT tokens for API authentication
- **Swagger**         - In-built swagger documentation support
- **Docker**          - Docker containers
- **Junit**           - Unit testing framework


## Application Structure
````
|____src
| |____main
| | |____java
| | | |____com
| | | | |____systango
| | | | | |____springboard
| | | | | | |____api
| | | | | | | |____v1
| | | | | | | | |____controller
| | | | | | | | |____request
| | | | | | |____domain
| | | | | | | |____model
| | | | | | | | |____user
| | | | | | | |____repository
| | | | | | |____dto
| | | | | | | |____model
| | | | | | | | |____user
| | | | | | | |____response
| | | | | | |____mapper
| | | | | | |____security
| | | | | | |____service
| | | | | | | |____admin
| | | | | | | |____exception
| | | | | | | |____user
| | | | | | |____util
| | |____resources
| | | |____static
| | | | |____css
| | | | |____img
| | | | |____js
| | | |____templates
| |____test
| | |____java
| | | |____com
| | | | |____systango
| | | | | |____springboard

````

## Running the server locally
The pom.xml can be configured to generate a WAR or standalone executable jar file as well. We suggest developers should use JAR in the development environment as the hot swapping and live reload features in Spring Boot are compatible with it and for production deployment WAR packaging should be used with standalone Tomcat (or any other servlet container) server.

## Docker
Springboard supports docker container out of the box. This framework is meant to cater to both web based applications as well as scalable micro services written in Java. The 'Dockerfile' supplied with this boilerplate does a basic job in terms of instructing which tomcat image to pick and how to deploy the war file to the container. Please follow the steps mentioned below in order to create and deploy the docker container from this installation -

* Create docker image from this project -
````
docker build -t springboard .

````

* Once image is created, you may run the same using the following command -
````
docker run -p 8090:8090 springboard

````

* Since we have not included a postgressql inside this container and are trying to connect to a database that is external to the container, you may need to enable the databsae to allow connections from foreign IP addresses which is disabled in case of default installations.

* Some handy dcoker comammnds are listed below, we found them useful during the course of this development and thought its worth sharing.
   - In order to delete all images, use the following command
   ````
   docker rmi --force $(docker images -q)
   ````
   - In order to delete all containers, use the following command
   ````
   docker rm $(docker ps -a -q)
   ````
   - In order to list all the running docker containers, use the following command
   ````
   docker ps
   ````
   - In order to list all the docker images, use the following command
   ````
   docker images
   ````
   - In order to get inside a docker container's command prompt, use the following command
   ````
   docker exec -it <mycontainer> bash
   ````
   
## Unit test cases
Springboard comes with a handy set of unit test cases present in the 'SpringboardApplicationTests' class inside the test directory. The test cases are based on the fact that spring security is applied, the first thing you should do before accessing a protected url in the application is obtain a valid JWT token using the utility method provided in the test suite. Once you have the valid token, any protected url could be unit tested without any issues.

## Swagger Documentation
Swagger documentation is in-built in this starter-kit and can be accessed at the following URL -
````
http://<host-name>:8090/swagger-ui.html
````
The configuration for swagger are driven via <b>com.systango.springboard.util.SwaggerConfig.java</b> class that at present shows all the apis listed under the <b>"com.systango.springboard.api.*"</b>package.
The JWT token should be presented inside the <b>value</b> input box as <b>"Bearer token_goes_here"</b>. The authorization header for the REST APIs should be as follows -
````
curl -X GET \
  http://localhost:8090/v1/about/faq \
  -H 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTUxNTMyMjU4Mn0.RHex52JtZZt0lfaZc_sHdwU8auevcT9COJDxp6RbBBU1ZbCEc6bh4b2CxjA8TSgH7DkwWIbO6ISqpMuUXNcZwA' \
  -H 'Cache-Control: no-cache' \
````

## Contributors
[Arpit Khandelwal](https://www.linkedin.com/in/arpitkhandelwal1984/)

## License
This project is licensed under the terms of the MIT license.