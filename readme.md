# Easy Software API
This project was generated from [Spring Initializer](https://start.spring.io/).

## Prerequisites
The following items should be installed in your system:
* [Java 8 or newer](https://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Git command line tool](https://help.github.com/articles/set-up-git)
* Your preferred IDE
    * Eclipse with the m2e plugin. Note: when m2e is available, there is an m2 icon in `Help -> About` dialog. If m2e is
      not there, just follow the install process here: https://www.eclipse.org/m2e/
    * [Spring Tools Suite](https://spring.io/tools) (STS)
    * IntelliJ IDEA
    * [VS Code](https://code.visualstudio.com)

## Database configuration
* No configuration is required as the project uses an in-memory `H2` Database Server

## Running The API locally
Easy Software is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/). You can build a jar file and run it from the command line:


```
git clone https://github.com/NdiranguMuchai/easy-software-test.git
cd easy-software
./mvnw package
java -jar target/*.jar
```

Or you can run it from Maven directly using the Spring Boot Maven plugin. If you do this it will pick up changes that you make in the project immediately (changes to Java source files require a compile as well - most people use an IDE for this):

```
./mvnw spring-boot:run
```

## Postman
A Postman collection has been provided to assist with endpoint requests.

* Open Postman.
* Select the `Import` button.
* Import the file found in this repository under `src/main/resource/EasySoftware.postman_collection.json`
* Expand the Easy Software folder in postman.

Each entry in this collection contains information in its `Body` tab if necessary.

## API Documentation
Once you run the application you can get documentation for the endpoints here: http://localhost:8080/swagger-ui.html#/