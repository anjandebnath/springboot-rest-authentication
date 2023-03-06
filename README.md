# Springboot-rest-authentication
Spring security with Rest API Authentication &amp; Authorization and Mysql DB connect with Docker Compose file


## Project Overview: Requirements
- [x] There will be two roles: USER & ADMIN.
- [x] Create a basic sign-up feature.
  1. Name
  2. Email
  3. Password
- [x] The pre-registered USERs can sign in using the login credentials (Name & Password).
- [x] After successful authentication, the user will get JWT token to authorize the APIs. 
- [x] Use Relational DB [MYSQL] to store data.
- [x] Docker compose for DB and db admin pannel.
- [x] Preload the Roles to DB when server startup.
- [x] After authentication, ADMIN create Taco ingredient types & Taco Ingredients. 
- [x] After authentication, ADMIN/USER both can request to get all Taco Ingredients List.


## Steps

### Project creation
1. Create a Spring boot project from https://start.spring.io/
2. Add necessary dependencies during the project creation.

### Docker
1. Install Docker [Desktop app](https://docs.docker.com/desktop/install/windows-install/) if not already installed.
2. It is a Docker client that connected to the Docker Deamon.
3. Pull the mysql and phpmyadmin docker image from the Docker Hub.
4. Inside the project create a `docker-compose.yml`file
5. Run the docker compose file to create the docker container.

### Connect MySql and PhpMyadmin
1. Run localhost:8989 to connect to the Admin panel.
2. This will require a MySql DB IP address to connect to the Database.
3. Run `docker container ls` and `docker inspect springboot-rest-authentication-db-1` to get the IP address.
4. After connecting the IP address, navigate to the database and browse the data.


## Used Annotation
| Spring Annotation        |                                                                                                                                                                                          Detail                                                                                                                                                                                           |
|--------------------------|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
| @Autowired               |                                                                                                                                                                          Constructor auto wirded for by default                                                                                                                                                                           |
| @Bean                    |                                                                                                                                                                                     Bean is an Object                                                                                                                                                                                     |
| @Configuration           |                                                                                                                                                   Spring Configuration annotation indicates that the class has @Bean definition methods                                                                                                                                                   |
| @Componenet              |                                                                                                                                                                        It expose a class as a Bean or Java Object                                                                                                                                                                         |
| @CrossOrigin             | It's common for javascript based user interface, such as those written in a framework like Angular or ReactJs, to be served from a separate host and/or port from the API, and the web browser will prevent the client from consuming the API.                                                                                                 It expose a class as a Bean or Java Object |
| @Getmapping @PostMapping |                                                                                                                                                                         To make methods available as REST methods                                                                                                                                                                         |
| @AllArgsConstructor      |                                                                                                                                             Lombok @AllArgsConstructor generates a constructor with 1 parameter for each field in your class.                                                                                                                                             |
| @NoArgsConstructor       |                                                                                                                                                         Lombok @NoArgsConstructor will generate a constructor with no parameters                                                                                                                                                          |
| @Data                    |                                                                                                                                           Lombok Data annotation. No need to write Getter and Setter methods and also handles default methods.                                                                                                                                            |
| @PreAuthorize            |                                                                         Method-level security is implemented by placing the @PreAuthorize annotation on controller methods                                                                                                Constructor auto wirded for by default                                                                          |
| @Repository              |                                                                                                                            JPA Repository methods are composed of a verb, an optional subject, the word By, and a predicate. No need to write traditional SQL.                                                                                                                            |
| @RestController          |                                                                                                    Tells spring that all handler methods should have their return value written directly to the body of the response, rather than being carried in the model to a view for rendering.                                                                                                     |
| @Service                 |                                                                      A user store that can handle more than one user. Normally, the default spring security provides a user with password credentials. In order to configure a user store for authentication purposes, you will need to declare a User Service Bean                                                                       |
| @SessionAttributes                |     A Controller is annotated with @SessionAttributes ("tacoOrder"). This indicates that the TacoOrder object that is put into the model a little later in the class should be maintained in session.                                                                                                                                    |
| @Transaction                |                                                                                                                                        Spring provides transaction management, which uses annotation to handle the multiple action of transaction.                                                                                                                                        |