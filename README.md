
====================
PROBLEM STATEMENT:
====================

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase. 

A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction

(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).

Given a record of every transaction during a three-month period, calculate the reward points earned for each customer per month and total. 

·  Make up a data set to best demonstrate your solution

·  Check solution into GitHub



====================
Directory Strutuctre
====================



```bash
.
├── mvnw
├── mvnw.cmd
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── charter
    │   │           └── client
    │   │               └── rewards
    │   │                   ├── Application.java
    │   │                   ├── ServletInitializer.java
    │   │                   ├── controller
    │   │                   │   └── RewardsController.java
    │   │                   ├── dto
    │   │                   │   ├── Customer.java
    │   │                   │   └── Transaction.java
    │   │                   ├── exceptionhandling
    │   │                   │   ├── CustomerNotFoundException.java
    │   │                   │   └── ExceptionHandlerController.java
    │   │                   ├── repository
    │   │                   │   └── CustomerRepository.java
    │   │                   └── service
    │   │                       ├── RewardService.java
    │   │                       └── RewardServiceImpl.java
    │   └── resources
    │       ├── application.properties
    │       ├── data.sql
    │       ├── schema.sql
    │       ├── static
    │       └── templates
    └── test
        └── java
            └── com
            
                └── charter
                    └── client
                        └── rewards
                            └── ApplicationTests.java

```

====================
DataSet
====================
-- The data is stored in a in memory H2 database. Insert queries are recorded in the data.sql file under the resources folder.  
-- We have 2 Database Schemas in schema.sql under the resources folder. Schema 1 = Customer Schema 2 = Transaction. They share a foreign key relationship on customer Id.

====================
Exception Handling
====================
Exception Handling for Customer Record which does not exist is performed via a custom Exception CustomerNotFoundException
Logging is provided as well.

====================
Unit Tests
====================
I have create a few Unit Tests for scenarios such as Transaction amount >100, lesser than 50 and between 50 and 100 as well. It is present in file ApplicationTests.java
User can run  mvn test to run the tests.

====================
To run:
====================
git clone https://github.com/rohitchawla8501/ClientRewardsREST
mvn clean compile
mvn spring-boot:run

====================
USAGE
====================
1. User can hit the following URL via GET Method for All customer Rewards--> /customers/rewards
2. User can hit the following URL via GET MEthod for Customer by Id--> /customers/rewards/{id} 
