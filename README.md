# Robotic hoover algorithm

### Requirements

* Java 11
* Docker

### How to run

Step-by-step:
1. Clone the project and ensure that docker service is running.
2. Run `docker-compose -f mysql.yml up -d` to start up the MYSQL (database and table will be create automatcally)
3. Run `gradlew build` to compile and generate the jar file.
4. Run `java -jar build/libs/demo-0.0.1-SNAPSHOT.jar` to run the project from jar file.

Or, run with one command:
```
docker-compose -f mysql.yml up -d && ./gradlew build && java -jar build/libs/demo-0.0.1-SNAPSHOT.jar
```

### How to use the API

1. The API will be run on 8080 port, that is will be run on http://localhost:8080
2. The API uri is `robotic-hoover` and the endpoint to execute the algorithm is `execute`
3. Should be used POST verb to send the informations.

The complete URI is `POST http://localhost:8080/robotic-hoover/execute`. Informations need be send on body and the instructions for input and output are bellow.

### How to connect to database

After start the MySQL using docker-compose, it's possible to connect using hostname `127.0.0.1:3306` with username `root` and password `root`.

## Introduction and problem explanation
You will write a service that navigates a imaginary robotic hoover (much like a Roomba) through an equally imaginary room based on:

- room dimensions as X and Y coordinates, identifying the top right corner of the room rectangle. This room is divided up in a grid based on these dimensions; a room that has dimensions X: 5 and Y: 5 has 5 columns and 5 rows, so 25 possible hoover positions. The bottom left corner is the point of origin for our coordinate system, so as the room contains all coordinates its bottom left corner is defined by X: 0 and Y: 0.
- locations of patches of dirt, also defined by X and Y coordinates identifying the bottom left corner of those grid positions.
- an initial hoover position (X and Y coordinates like patches of dirt)
- driving instructions (as cardinal directions where e.g. N and E mean "go north" and "go east" respectively)

The room will be rectangular, has no obstacles (except the room walls), no doors and all locations in the room will be clean (hoovering has no effect) except for the locations of the patches of dirt presented in the program input.

Placing the hoover on a patch of dirt ("hoovering") removes the patch of dirt so that patch is then clean for the remainder of the program run. The hoover is always on - there is no need to enable it.

Driving into a wall has no effect (the robot skids in place).

### Goal
The goal of the service is to take the room dimensions, the locations of the dirt patches, the hoover location and the driving instructions as input and to then output the following:

- The final hoover position (X, Y)
- The number of patches of dirt the robot cleaned up

The service must persist every input and output to a database.

### Input
Program input will be received in a json payload with the format described here.

Example:

```javascript
{
  "roomSize" : [5, 5],
  "coords" : [1, 2],
  "patches" : [
    [1, 0],
    [2, 2],
    [2, 3]
  ],
  "instructions" : "NNESEESWNWW"
}
```

### Output
Service output should be returned as a json payload.

Example (matching the input above):

```javascript
{
  "coords" : [1, 3],
  "patches" : 1
}
```

Where `coords` are the final coordinates of the hoover and patches is the number of cleaned patches.

### Sources

Details can be find on <a href="https://github.com/lampkicking/yoti-sdk-backend-test">yoti-sdk-backend-test</a> or on this <a href="https://gist.github.com/alirussell/9a519e07128b7eafcb50">gist</a>.
