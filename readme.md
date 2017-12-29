![Springboard](https://github.com/SystangoTechnologies/Springboard/blob/master/src/main/resources/static/img/springboard-logo.jpg)

## Springboard
Production ready maven based Spring Boot starter kit application.

## Description
Starter kit for jump starting the development of a API oriented spring based Java server. It contains the best practices and latest tools that a spring boot developer should opt for in a fresh development. Since JPA is used, developers are free to opt for any SQL based DB engine for persistence (Postgres has been used as an example with this code sample). The preferred IDE for development is IntelliJ which comes with a plethora of useful JAVA tools to support Spring Boot development, but devlopers are free to opt for Eclipse or STS as well.

## Technology

- **Spring Boot** - Server side framework
- **JPA** - Entity framework
- **Lombok** - Provides automated getter/setters
- **Actuator** - Application insights on the fly
- **Spring Security** - Spring's security layer
- **Thymeleaf** - Template Engine
- **Devtools** - Support Hot-Code Swapping with live browser reload
- **JJWT** - JWT tokens for API authentication


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

## Contributors
[Arpit Khandelwal](https://www.linkedin.com/in/arpitkhandelwal1984/)