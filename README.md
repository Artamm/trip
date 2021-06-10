# Trip (README TBD)
A homework for "month with IT 2021"

## About
Project is based on Spring Boot. There are 2 options how to use:
 - Web version with form. Available at localhost port `8080` for local .jar run and port `8081` if used Docker setup
 - Getting JSON answers. Use Postman and type something like 
 `curl -X POST -H "Content-type: application/json" -d "{\"distance\" : \"3\", \"start\" : \"2021-06-21\",\"participants\" : \"2\"}" "http://localhost:8080/trip/new"`
 
 ### Setup
 1. Clone repository
 2. Run `mvn package`
 3. Inside `target` folder with prepared jar, run           

            java -jar trip-0.0.1-SNAPSHOT.jar
    Available at [http://localhost:8080/][http://localhost:8080]
 
   OR 
           
            docker build -t Dockerfile . 
   in the root folder. Available at [http://localhost:8081/][http://localhost:8081]
   


[http://localhost:8080]: http://localhost:8080/
[http://localhost:8081]: http://localhost:8081/

####Usage
#####Web 
