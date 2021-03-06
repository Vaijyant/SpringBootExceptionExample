## Environment:
- Java version: 1.8
- Maven version: 3.*
- Spring Boot version: 2.2.1.RELEASE

## Read-Only Files:
- src/test/*

Given a rest controller class `FizzBuzzController.java`, there is a `GET` API endpoint to be modified, which can throw three types of runtime exceptions:
1. FizzException
2. BuzzException
3. FizzBuzzException 

Below is the endpoint for the `GET` API endpoint with a single path parameter.

`GET /controller_advice/{code}`

Exceptions are to be thrown based on the value of the path param `{code}` passed to the rest API.

Here is a series of requests and their corresponding expected responses:

`GET /controller_advice/fizz`:

Response Code: 500

Response Body:
```json
{
    "message": "Fizz Exception has been thrown",
    "errorReason" : "Internal Server Error"
}
```

`GET /controller_advice/buzz`:

Response Code: 400

Response Body:
```json
{
    "message": "Buzz Exception has been thrown",
    "errorReason" : "Bad Request"
}
```

`GET /controller_advice/fizzbuzz`:

Response Code: 507

Response Body:
```json
{
    "message": "FizzBuzz Exception has been thrown",
    "errorReason" : "Insufficient Storage"
}
```

`GET /controller_advice/success`:

Response Code: 200

Response Body:
```json
{
    "message": "Successfully completed fizzbuzz test",
    "statusCode": "200"
}
```

## Commands
- run: 
```bash
mvn clean package; java -jar target/RestControllerAdvice-1.0.jar
```
- install: 
```bash
mvn clean install
```
- test: 
```bash
mvn clean test
```
