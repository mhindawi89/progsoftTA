# progsoftTA
Progress Soft Technical Assignment  

Stack: Spring Boot, Java 17, Hibernate, MySQL 

ClusteredData Warehouse
Suppose you are part of a scrum team developing data warehouse for Bloomberg to analyze FX deals. One of customer stories is to accept deals details from and persist them into DB.


Request logic as following:

Request Fields(Deal Unique Id, From Currency ISO Code "Ordering Currency", To Currency ISO Code, Deal timestamp, Deal Amount in ordering currency).
Validate row structure.(e.g: Missing fields, Type format..etc. We do not expect you to cover all possible cases but we'll look to how you'll implement validations)
System should not import same request twice.
No rollback allowed, what every rows imported should be saved in DB.

Deliverables should be ready to work including:

Use Actual Db, you can select between (Postgres, MySql or MongoDB)
Workable deployment including sample file (Docker Compose).
Maven or Gradle project is required for full source code.
Proper error/exception handling.
Proper Logging.
Proper unit testing with respected Coverage.
Proper documentation using md.
Delivered over Githhub.com.
Makefile to streamline running application (plus). 

To be able to run the service you need to setup mysql database loacally, or toy can just run the docker-compose file to run the database after that you need to run the project as spring boot app.
command " mvn spring-boot:run".

And you can upload the Deals File with th end point 
http://localhost:8080/uploadFile
