# Spring Boot API Starter

## Getting Started

### DB SETUP
`application.properties` will need to be updated with your username, and or db name.
Check out the database.sql for getting books to work. Books are just an example!

### GRADLE WRAPPER
To start your server, type `./gradlew bootrun`

Go to: http://localhost:8080/

You should see the hello greeting from the `HelloController` file for GET "/"

To stop, `control + c` (same as node)

# Learning Java Day 2!

## Getting into servers!

Gradle and Springboot are the two things we'll use.

Gradle is the framwork that runs the server
Springboot is like Express -- allows us to handle the different routes and what to do with them

`./gradlew bootrun` will start the server based on the code in your files, and any time you change server code you need to re-start it.
Confusingly, it sits at 75% executing forever until you tell it to stop -- this means that your server is running, becauseit hasn't finished.

Springboot provides the controllers.  Things like:
`@RestController` - which 
