# Tenlegsdemo
Demo Project Done for tenlegs

It is a REST-ful API written using JAX-WS. There is a key component that is missing *config.properties*
it should be a text file containing the following. <br>

driver=*'appropriate driver for the chosen database'*<br>
url=*'jdbc complete url with database specified'* <br>
user=*username* <br>
pass=*password* <br>

the *config.properties* must be located in the __src__ folder<br>

### Running
Import the project into Spring Tool Suite or Eclipse and run it on tomcat or any other server of your choice.<br>

### Database Schema
![alt text](http://s14.postimg.org/ios3ifnql/Untitled_Diagram.png "Datanbase Schema")


### Deployment
The entire project can be exported into a **_.war_** file that can be deployed into any supported webserver.<br>

### Docker
The application has been built into a Docker container and can be [pulled](https://hub.docker.com/r/agrimasthana/tenlegsapi/)

### Demo
The API has been deployed at **_api.agrimasthana.com/tenlegs/user/_** with basic _GET_ , _PUT_ , _POST_ , _DELETE_ methods <br>
that can be seen in  _UserController.java_

### Api-Reference
Except for GET requests all other requests need the request header 'Content-Type' to be set to 'application/json'

| Method        | Input         | Output|
| ------------- |:-------------:| -----:|
|GET /user/     | none          |List of all users |
|GET /user/1    | none          | details of user with id 1 |
|POST /user/    | JSON object of user with date_joined optional      |HTTP 201 |
|PUT /user/    | JSON object of exiting user with valid id      |HTTP 200 |
|DELETE /user/2    | none      |HTTP 200 |
