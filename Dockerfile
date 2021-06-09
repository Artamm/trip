FROM openjdk:11-jre
ADD  /target/trip-0.0.1-SNAPSHOT.jar trip-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT  ["java","-jar","trip-0.0.1-SNAPSHOT.jar"]
