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

Gradle and Springboot  and jdbcTemplate are the things we'll use.

Gradle is the framwork that runs the server
Springboot is like Express -- allows us to handle the different routes and what to do with them
jdbcTemplate is our pool -- allows us to send SQL code to the database

`./gradlew bootrun` will start the server based on the code in your files, and any time you change server code you need to re-start it.
Confusingly, it sits at 75% executing forever until you tell it to stop -- this means that your server is running, becauseit hasn't finished.

Springboot provides the controllers and annotations, etc.  Things like:
`@RestController` and `@RequestMapping`
Everything here is ran in the background, handled by Spring.  YOu can see the starting code in Application.java where we see SpringApplication.run()

all our routes are handled within the HelloController.java file.
There we import our Spring annotations, and use them to wrap the HelloController class methods so they handle requests made to the url passed to them.
Here we can also see the jdbcTemplate.query() or .update() being called with our sql queries.
Data can be sent on posts, and using the mapping annotations it can then be accessed with `@RequestBody`
That expects JSON data.

on the `@DeleteMapping` annotation, we use a path param `(/url/{id})` to pass the id to delete.
That can be accessed via `@PathVariable`

