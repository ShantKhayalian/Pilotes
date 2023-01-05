# springboot-Pilotes-exam-app


## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
- [Maven 3](https://maven.apache.org)
- [Docker](https://www.docker.com/)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.app.pilotes.PilotesApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn clean install
mvn spring-boot:run
```

## Running the application on Docker

The easiest way to docker is to use the docker-compose file:

```shell
docker compose up
...

This will create:

* Docker image of the app
* Download and prepaire all nessecery files to run the app
* Host: localhost
* Port: 8080
```
## Running the endpoints

The easiest way to get all the endpoints is to use Swagger Open Api documentations
```shell
http://localhost:8080/swagger-ui.html
```

## Checking the results in the database level

The application uses H2 in memory database, simply you can check the tables and the data inside.
```shell
http://localhost:8080/h2-console/
```

Using your credentials to log in, the default will be 
```shell
username : sq
password : 
```

## Checking the dependencies
To check all the dependencies.
```shell
mvn dependency:tree
```
## Checking the test coverage

The application test coverage.
Rigth click with the mouse on the src/main/java/com/app/pilotes folder, 
from the popup menu navigate to the MORE run/debug, 
and select Run test with coverage.
The application is on 84% covegae, 
and could be pass the 90% but needs extra time to work on it.


## Created by

Shant Khayalian
