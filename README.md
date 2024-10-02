# Blogging Platform

A simple blogging platform built using Spring Boot, MongoDB, and RESTful APIs. The platform allows users to create, update, delete, and retrieve articles and comments associated with articles.

> **Note**: This is my personal project, and I am trying to explore it as deeply as I can.  
> Thank you for taking the time to explore it as well.

## Table of Contents

- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
    - [Running the Application](#running-the-application)
- [Project Structure](#project-structure)
- [API Endpoints](#api-endpoints)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Getting Started

### Prerequisites

Before you begin, ensure you have the following installed:

- **Java Development Kit (JDK)**: Version 11 or higher
- **Maven**: For building and managing dependencies
- **MongoDB**: Ensure MongoDB is installed and running on your machine
- **Postman** (optional): For testing the API endpoints

### Installation

1. **Clone the repository**:

    ```bash
    git clone https://github.com/your-username/blogging-platform.git
    cd blogging-platform
    ```

2. **Set up MongoDB**:
   Ensure MongoDB is running on its default port (`27017`).

3. **Build the project**:

    ```bash
    mvn clean install
    ```

4. **Configure Application Properties**:
   Update the `src/main/resources/application.properties` file with your MongoDB connection settings if necessary.

    ```properties
    spring.data.mongodb.database=bloggingPlatformDB
    spring.data.mongodb.port=27017
    spring.data.mongodb.host=localhost
    ```

### Running the Application

Run the application using Maven:

```bash
mvn spring-boot:run
```
````
src/
├── main/
│   ├── java/com/leafBlog/Leaf/Blog/
│   │   ├── Controller/         # REST Controllers
│   │   ├── Entity/             # MongoDB Entity Classes
│   │   ├── Repository/         # Repositories for MongoDB
│   │   ├── Services/           # Service Layer for Business Logic
│   │   └── Application.java    # Main Application Class
│   └── resources/
│       ├── application.properties   # Application Configuration
└── test/                           # Unit and Integration Tests
````

## API Endpoints

### Article Endpoints

- **Get All Articles**: `GET /api/articles`
- **Get Article by ID**: `GET /api/articles/{id}`
- **Search Articles by Title**: `GET /api/articles?search=Spring`
- **Search Articles by Author**: `GET /api/articles?author=Spring`
- **Search Articles by Author & Title**: `GET /api/articles?author=Spring&author=John Doe`
- **Create Article**: `POST /api/articles`
- **Update Article**: `PUT /api/articles/{id}`
- **Delete Article**: `DELETE /api/articles/{id}`

### Comment Endpoints

- **Get All Comments for an Article**: `GET /api/articles/{articleId}/comments`
- **Create Comment for an Article**: `POST /api/articles/{articleId}/comments`

## Testing

You can test the API using Postman or any other API testing tool. Here are some examples:

1. **Get All Articles**:
    - Method: `GET`
    - URL: `http://localhost:8080/api/articles`
    - Method: GET
    - URL: `http://localhost:8080/api/articles?search=Spring`
    - Filter Articles by Author:
    - URL: `http://localhost:8080/api/articles?author=JohnDoe`
    - Search Articles by Title and Filter by Author:
    - URL: `http://localhost:8080/api/articles?search=Spring&author=John Doe`

2. **Create a New Article**:
    - Method: `POST`
    - URL: `http://localhost:8080/api/articles`
    - Body (JSON):
      ```json
      {
          "title": "My First Article",
          "content": "This is the content of my first article.",
          "author": "John Doe"
      }
      ```

3. **Create a Comment for an Article**:
    - Method: `POST`
    - URL: `http://localhost:8080/api/articles/{articleId}/comments`
    - Body (JSON):
      ```json
      {
          "content": "Great article!",
          "author": "Jane Smith"
      }
      ```

## Contributing

Contributions are welcome! To contribute:

1. Fork the repository.
2. Create a new feature branch.
3. Make your changes and commit them.
4. Push your branch and create a Pull Request.

Please make sure your code follows the established style and conventions.

