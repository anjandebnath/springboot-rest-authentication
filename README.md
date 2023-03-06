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