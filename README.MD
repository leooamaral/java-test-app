# Final Test

## Requirements

Before start playing with this application, please your requirements attends to following requirements:
1. Have open-jdk-11 installed and $JAVA_HOME env variable properly set
2. No other process listening on port **_8080_** of your local environment


### How to build this application?

<code>./gradlew clean build bootJar</code>

### How to build this application?

<code>java -jar  build/libs/aggregation-service-0.0.1-SNAPSHOT.jar</code>


### How can I validate everything is working as expected?

This is a simple WEB API, the best way to test is to play with It

1. Call the health endpoint

<code> curl http://localhost:8080/actuator/health </code>

returns: 
<code>{"status":"UP"}</code>

2. Add a new record and use the id returned by this call on the next call
<code> 
curl -X PUT  "localhost:8080/employees/" -H 'Content-Type: application/json' -d'  {
   "name": "jack",
   "age": 39,
   "cpf": "1234567"
}'
</code>


3. Query the record saved on the previous step:

<code>curl localhost:8080/employees/[REPLACE_BY_THE_ID_FROM_PREVIOUS_STEP]</code>


4. Query all records available

v<code>curl localhost:8080/employees</code>