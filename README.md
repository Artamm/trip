# Trip (README TBD)
A homework for "month with IT 2021"

## About
Project is based on Spring Boot. There are 2 options how to use:
 - Web version with form. Available at localhost port `8080` for local .jar run and port `8081` if used Docker setup
 - Getting JSON responses. Use Postman and type POST request. Example:
 
        curl -X POST -H "Content-type: application/json" -d "{\"distance\" : \"3\", \"start\" : \"2021-06-21\",\"participants\" : \"2\"}" "http://localhost:8080/trip/new"
 
 ### Setup
 1. Clone repository
 2. Run `mvn package`. Make sure that your `JAVA_HOME` variable is at least JDK 11.
 3. Inside `target` folder with prepared jar, run           

            java -jar trip-0.0.1-SNAPSHOT.jar
    Available at [http://localhost:8080/][http://localhost:8080]
 
    Alternatively, you can create a Docker image. Inside root folder type
           
            docker build -t trip . 
    App will be available at [http://192.168.99.100:8081/][http://192.168.99.100:8081/]
   


[http://localhost:8080]: http://localhost:8080/
[http://192.168.99.100:8081/]: http://192.168.99.100:8081/


## Additional information

#### Web 

#### JSON 
