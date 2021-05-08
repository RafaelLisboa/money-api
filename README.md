<h1 align="center">💲 Money API 💲</h1>
<p align="center"><i>Expenditure Listing API Rest</i></p>
<div align="center">
<img src="https://img.shields.io/github/license/RafaelLisboa/money-api" alt="License Badge"/>
<img src="https://img.shields.io/github/forks/RafaelLisboa/money-api" alt="Forks Badge"/>
<img src="https://img.shields.io/badge/language-Java-orange" alt="Language Badge"/>
<img src="https://img.shields.io/badge/db-MySQL-blue" alt="Database Badge" >
<img src="https://img.shields.io/badge/container-docker-blue" alt="Container Badge" >
</div>
<br>
<br>
#### Project where I implement concepts such as query string, pagination, error handling in requests and packaging of the application in a Docker 🐳 container I used the Flyway library for versioning the database


You can run the entire project on your machine (if you have the <a href="https://www.docker.com/">Docker<a/> installed) giving only one `docker compose up` on

### Entity
  - 🧑 Person
  - 💱 Category
  - 💹 Launch

The controllers do not know and do not do any type of operation directly in the repository classes, everything is done in the service layer of the application to separate the responsibilities

## 🔁 Endpoints
  ### 💹 Launch
    - GET     /launch returns all lauch made
    - GET     /launch/{id} returns launch compatible with id
    - POST    /launch a new release persists
    - DELETE  /launch/{id} removes the launch compatible with the id

  ### 🧑 Person
    - GET     /person returns all person
    - GET     /person/{id} returns person compatible with id
    - POST    /person a new person persists
    - DELETE  /person/{id} removes the person compatible with the id
    - PUT     /person/{id} updates data of an already persisted person
  
  ### 💱 Category
    - GET     /categories returns all categories made
    - GET     /categories/{id} returns categories compatible with id
    - POST    /categories a new categories persists
    - DELETE  /categories/{id} removes the categories compatible with the id


## ⚙ Set
  You only need to have the docker installed and run the command
  `docker compose up`
  In the project's root folder

Give a ⭐️ if this project helped you!
