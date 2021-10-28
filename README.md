

Problem Statement:
====================

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase. 

A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction

(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).

Given a record of every transaction during a three-month period, calculate the reward points earned for each customer per month and total. 

·  Make up a data set to best demonstrate your solution

·  Check solution into GitHub




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
    │   │                   ├── RewardsApplication.java
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
                            └── RewardsApplicationTests.java

```


DataSet
====================
-- The data is stored in a in memory H2 database. Insert queries are recorded in the data.sql file under the resources folder.  
-- We have 2 Database Schemas in schema.sql under the resources folder. Schema 1 = Customer Schema 2 = Transaction. They share a foreign key relationship on customer Id.


Exception Handling
====================
Exception Handling for Customer Record which does not exist is performed via a custom Exception CustomerNotFoundException
Logging is provided as well.


Unit Tests
====================
I have create a few Unit Tests for scenarios such as Transaction amount >100, lesser than 50 and between 50 and 100 as well. It is present in file RewardsApplicationTests.java
User can run  mvn test to run the tests.


To run:
====================
git clone https://github.com/rohitchawla8501/ClientRewardsREST  
mvn clean compile  
mvn spring-boot:run


Usage
====================
1. User can hit the following URL via GET Method for All customer Rewards--> /customers/rewards
2. User can hit the following URL via GET MEthod for Customer by Id--> /customers/rewards/{id} 

After the program is run, user can enter the following link in the URL:
http://localhost:8080/customers/rewards. 
OR  
http://localhost:8080/customers/rewards/2

Example Expected Output for http://localhost:8080/customers/rewards/2

{
  "id" : 2,
  "name" : "Bob",
  "firstMonthRewards" : 180,
  "secondMonthRewards" : 180,
  "thirdMonthRewards" : 180,
  "totalRewardAmount" : 540
}


TROUBLESHOOTING
====================
1. If errors are experienced, user can enable debug logs . User can enable debug logs to check the flow. The following can be uncommented from the application.properties file #logging.level.com.charter.client=DEBUG. 
2. If Test Cases fail, make sure the data.sql file has not been changed.  
3. REST API does not receive any data: 
-Check if correct URL is used  
-Also user can use the following link to log into the H2 database to check if data is getting populated.
Link http://localhost:8080/h2
Properties are below:
JDBC URL =jdbc:h2:mem:testdb
UserName = sa 
There is no password.

