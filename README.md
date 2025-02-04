# Los Enlaces PetStore

## Description

Small application using spring-boot.
The application main objective is manage a DB of Pets through a rest api,
for that we have to develop endpoints to create, retrieve, update and delete Pets from the DB.

For data storage we are going to use an in-memory DB.

## API Reference

### Pet Store API: /pet-shop

### Create Pet

```http
  Post /pet
```

##### Request

```json
{
  "name": "leela",
  "description": "Crazy little cat",
  "type": "CAT"
}
```
##### Response

```json
{
  "name": "leela",
  "description": "Crazy little cat",
  "type": "CAT",
  "documentId": "5F7dvkDrI6dSktf5hYLf"
}
```

### Get All Pet

```http
  GET /pets
```

##### Response

```json
[
  {
    "name": "leela",
    "description": "Crazy little cat",
    "type": "CAT",
    "documentId": "5F7dvkDrI6dSktf5hYLf"
  }
]
```

### Get Pet by Id

```http
  GET /pet/{id}
```

##### Response

```json
{
  "name": "leela",
  "description": "Crazy little cat",
  "type": "CAT",
  "documentId": "5F7dvkDrI6dSktf5hYLf"
}
```

### Update Pet

```http
  PUT /pet/{id}
```

##### Request

```json
{
  "name": "leela",
  "description": "UPDATED - Crazy little cat",
  "type": "CAT"
}
```

##### Response

```json
{
  "name": "leela",
  "description": "UPDATED - Crazy little cat",
  "type": "CAT",
  "documentId": "5F7dvkDrI6dSktf5hYLf"
}
```

### Delete Pet

```http
  DELETE /pet/{id}
```

##### Response

```json
{
  "name": "leela",
  "description": "UPDATED - Crazy little cat",
  "type": "CAT",
  "documentId": "5F7dvkDrI6dSktf5hYLf"
}
```

### Postman Collection

- Find collection of calls that can be used in Postman in [./src/main/resources/postman](./src/main/resources/postman)



### Additional Resources
- Validate sytem config
  - java --version
  - mvn --version
  - git --version
- [Miro Board](https://miro.com/welcome/VnV4ajlON3NwNzVqVFY5QVRHL0k4eWtUVHZVbFBaNVFWanRsUGUvVmZsM2VsQ09PZWhxV3EzN3I1YTVwT25iTFY5dUZ6Mm1nSlcyUDNzekRNNmg0SFo4a3BrRnozNTNNVWZPd0p5T3BsZXJiWmorUDNpcVYyVVNxRDkyTmZUZXohZQ==?share_link_id=972822618721)
- Run Firestore locally
  - gcloud emulators firestore start --host-port=0.0.0.0:9085
- Run docker image locally
  - docker run -e FIREBASE_HOST=host.docker.internal:9085 -p 8080:8080 europe-southwest1-docker.pkg.dev/petstore-448521/pet-store-repository/los-enlaces-petstore:1.0.0-SNAPSHOT
- Execute Jacoco
  - mvn clean test
- Documentation
  - http://localhost:8080/swagger-ui/index.html#/
  - http://localhost:8080/v3/api-docs.yaml