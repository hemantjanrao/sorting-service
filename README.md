[![Build Status](https://travis-ci.org/hemantjanrao/sorting-service.svg?branch=master)](https://travis-ci.org/hemantjanrao/sorting-service)

# Getting Started

## Summary

Framework is build using the stack
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
* [Lombok](https://projectlombok.org/)
<br>

#### Required software to run tests from IDE
Install *Required software to run tests from IDE* 
* [IntelliJ IDEA](https://www.jetbrains.com/de-de/idea/)
* Add Lombok plugin in IntelliJ IDEA from plugin market place

#### Run tests
1. Clone the repository.
2. Go to ***sorting-service*** folder.
3. run test as mentioned below

##### To run tests     
        mvn clean test

#### Run application
1. Clone the repository.
2. Go to ***sorting-service*** folder.
3. run application as mentioned below   
     
        ./mvnw clean spring-boot:run
4. Goto Web browser \
    SORT: \
    http://localhost:8081/sort?values=10,5,18,35,4,78
    
    REVERSE:\
    http://localhost:8081/reverse?values=10,5,18,35,4,78         
        

