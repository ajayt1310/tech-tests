# Translator SpringBoot Rest API 

## Pre-requisite

Ensure you have maven installed in your system. You can install it from [https://maven.apache.org/](https://maven.apache.org/)

Also ensure maven path is set in you System so that you can run `mvn` commands

## Cloning the code to your local

Clone this code to your local using the following command

```bash
git clone https://github.com/ajayt1310/tech-tests.git
```

Or you can import the project into an IDE of your choice. I Used Eclipse to test this out

## Run the Application

The Application can be run using the following command 

```bash
mvn spring-boot:run
```
## What is the use of this Repo

This Project is a Translate Engine Rest API Project which demonstrates the following
1. Host a REST API end point at root.
2. Making HTTP Get calls
3. This Api takes two fields Name and Amount (in digits). User has to enter name and amount and has to submit the information to backend springboot application API which takes both the fields as inputs and gives output in JSON having Name translated in capital case, entered amount (in digits) and enterted amount in words in JSON. 

## Technology Used
- SpringBoot 2.5.7
- Java 8
- Maven 3.5.2
- Junit 4
- Eclipse IDE

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.7/maven-plugin/reference/html/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.0/reference/htmlsingle/#boot-features-developing-web-applications)
