# MEDIUM-ARTICLES-API
Hello there! Welcome to this software repository.  Let me guide you through some important aspects of this project.

## Description
* This project implements all of the CRUD operations for an ARTICLES table from a database named MEDIUM.  I have added SQL resource files to create the necessary DB artifacts. The database is AlloyDB configured in high-availability mode and having one read replica.

## Framework
* This project has been developed using Spring Boot 3 working with OpenJDK 21.

## Cloud Infrastructure
All services have been deployed to the WEST1 region in Google Cloud Platform:
* Database Service: AlloyDB.
* Cache Service: Memorystore for Redis.
* Compute Service: Cloud Run (Serverless).