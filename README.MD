# QuizBear
QuizBear is a multiplayer quiz webapp with AI generated content
docker run -p 8080:8080 quizbear/frontend

## Usage

When running locally using the directions below, the application can be accessed in the browser at http://localhost:8080/

### Run with a Docker image (Docker)

Build the Docker Image from the Dockerfile
```
docker build -t quizbear/frontend .
```
Run the Docker image
```
docker run -p 8080:8080 quizbear/frontend
```

### Run with Gradle
Execute the shell script below

```
./gradlew bootRun
```

### Run with Jar file

```
java -jar target/frontend-[version]-SNAPSHOT.jar
```

## Application Requirements

Java version: 21 (OpenJDK)
Build System: [Gradle](https://gradle.org/)

## Endpoint Documentation


## License
[Unlicense](https://choosealicense.com/licenses/unlicense/)