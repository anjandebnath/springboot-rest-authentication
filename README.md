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
