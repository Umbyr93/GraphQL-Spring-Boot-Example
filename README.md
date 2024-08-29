# GraphQL + Spring Boot Example
Start this example as a normal **Spring Boot Application**.

## H2
**H2** is the embedded database and its console is accessible, while the app is running, at the following endpoint: **localhost:8080/h2-console**

### Parameters
**JDBC URL**: jdbc:h2:mem:test \
**User name**: sa \
**Password**: empty

## GraphQL
There are 2 ways to call the **GraphQL APIs**:
1. Using the **GraphiQL** tool at the following endpoint: **localhost:8080/graphiql**
2. Calling the endpoint (**POST /graphql**) using clients like Postman with the query as the body

## Query example
### First Query:
```graphql
query My_Query {
    findById(id: 1) {
        id
        title
        author
    }
}
```
Response:
```json
{
    "data": {
        "findById": {
            "id": "1",
            "title": "The Lord of the Rings",
            "author": "Tolkien"
        }
    }
}
```

### Second Query:
```graphql
query My_Query {
    findById(id: 1) {
        id
        title
        author
    }
    allBooks {
        id
        title
        author
    }
}

```
Response:
```json
{
    "data": {
        "findById": {
            "id": "1",
            "title": "The Lord of the Rings",
            "author": "Tolkien"
        },
        "allBooks": [
            {
                "id": "1",
                "title": "The Lord of the Rings",
                "author": "Tolkien"
            },
            {
                "id": "2",
                "title": "Harry Potter",
                "author": "Rowling"
            }
        ]
    }
}
```