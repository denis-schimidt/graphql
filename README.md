# Spring boot - CRUD - GraphQL

### Start project

`./gradlew build -x test && docker-compose up --build`

### Create Author

```graphql
mutation {
  createAuthor(author:{
   	fullname: "Dênis Schimidt",
		email: "denis.oliveira@elo7.com"
  }) {
    fullname,
  	email
  } 
}
```

### Find Author

##### Request

```graphql
query {
  findAuthor(email: "denis.oliveira@elo7.com") {
    email
    fullname
    books {
      title
      isbn
    }
  }
}
```

##### Response
```json
{
  "data": {
    "findAuthor": {
      "email": "denis.oliveira@elo7.com",
      "fullname": "Dênis Schimidt",
      "books": [
        {
          "title": "Hard Die",
          "isbn": "09346259-348e-4a12-b908-d833d92d07f0"
        },
        {
          "title": "Harry Porter",
          "isbn": "4e10a8f9-014f-452a-8d2a-f82f56fd2b9e"
        },
        {
          "title": "Indiana Jones",
          "isbn": "5ac92f3b-5a9a-42eb-8f97-f3012708f389"
        }
      ]
    }
  }
}
```

#### Create Book

```graphql
mutation {
  createBook(email:"denis.oliveira@elo7.com", book: {
    title: "Hard Die",
    subject: "action"
  }) {
    title
    subject
  }
}
```

### Find Book

```graphql
query {
  findBook(isbn: "09346259-348e-4a12-b908-d833d92d07f0") {
    author {
      email
      fullname
    }
    title
  }
}

```

CURL
-----------------
```bash
curl -i -H 'Content-Type: application/json' -X POST -d '{"query":"query {listAllBooks(pageRequest:{page:0, size:40}){title subject reviews{stars} author{email} } }" }' http://localhost:8080/graphql
```