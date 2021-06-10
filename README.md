# Trip
A homework for "month with IT 2021"

## About
Project is based on Spring Boot. There are 2 options how to use:
 - Web version with form. Available at localhost port `8080` for local .jar run and port `8081` if used Docker setup
 - Getting JSON responses. Use Postman and type POST request. Example:
 ``` javascript
        curl -X POST -H "Content-type: application/json" -d "{\"distance\" : \"3\", \"start\" : \"2021-06-21\",\"participants\" : \"2\"}" "http://localhost:8080/trip/new"
 ```
 ### Setup
 1. Clone repository
 2. Run `mvn package`. Make sure that your `JAVA_HOME` variable is at least JDK 11.
 3. Inside `target` folder with prepared jar, run           

            java -jar trip-0.0.1-SNAPSHOT.jar
    Available at [http://localhost:8080/][http://localhost:8080]
 
    Alternatively, you can create a Docker image. Inside root folder type
           
            docker build -t trip . 
    App will be available at [http://192.168.99.100:8080/][http://192.168.99.100:8080/]
   


[http://localhost:8080]: http://localhost:8080/
[http://192.168.99.100:8081/]: http://192.168.99.100:8081/


## Additional information

#### Web 
Main page
![image_1](https://user-images.githubusercontent.com/36459172/121527595-3e11d200-ca03-11eb-9614-b903b9fa1e11.JPG)
Result page
![image_2](https://user-images.githubusercontent.com/36459172/121527871-90eb8980-ca03-11eb-8f0d-bbd363c83367.JPG)

#### JSON
Request
```javascript
 curl -X POST -H "Content-type: application/json" -d "{\"distance\" : \"3\", \"start\" : \"2021-06-21\",\"participants\" : \"2\"}" "http://localhost:8080/trip/new"
```

Response
```javascript
{
    "foodList": {
        "sandwich": 6,
        "snacks for dog": 6,
        "biscuits/other snacks": 4,
        "bottle of water": 4
    },
    "clothesList": {
        "a pair of sandals": 2,
        "sunglasses": 2,
        "cap": 2,
        "shorts": 2,
        "t-shirt": 2
    },
    "otherRequiredStuff": {
        "wallet": 2,
        "disinfectant": 2,
        "phone": 2,
        "documents": 2,
        "swimsuit": 2,
        "first aid kit": 2,
        "pyjama": 2,
        "mask": 2
    },
    "distance": 3.0,
    "start": "2021-06-21",
    "end": null,
    "destination": null,
    "participants": 2,
    "camping": false
}
```
Properties
``` javascript
                "{\"distance\" : \"\",
                   \"start\" : \"\",
                   \"end\" : \"\",
                   \"destination\" : \"\",
                   \"participants\" : \"\",
                   \"camping\" : \"\",
                   }";

```
