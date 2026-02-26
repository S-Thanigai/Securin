Installation Requirements:

Java 21 - Required by the project

To run the backend

.\mvnw spring-boot:run

java -jar target\backend-0.0.1-SNAPSHOT.jar

The backend will run on 

http://localhost:8080/

H2 base will be available on
http://localhost:8080/h2-console

First api POST
use POSTMAN
http://localhost:8080/addRecipe

Second api GET

http://localhost:8080/recipes/top?limit=  (the limit value after the "=" sign)
