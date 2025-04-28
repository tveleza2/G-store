
# Grocery Store Manager

Stock Manager is a Spring Boot-based application designed to manage product inventory. It provides RESTful APIs for creating, reading, updating, and deleting products, as well as toggling their active status. The application uses MySQL as the database and integrates with Spring Security, Spring Data JPA, and MapStruct for efficient development.

## Features

- **Product Management**: Create, read, update, and delete products.
- **Toggle Product Activation**: Enable or disable products.
- **Validation**: Ensures product data integrity.
- **RESTful APIs**: Exposes endpoints for managing products.
- **Swagger Integration**: API documentation available at `/swagger-ui.html`.
- **Database Integration**: Uses MySQL for persistent storage.
- **Security**: Configurable Spring Security setup.

## Project Structure

```markdown
src/
├── main/
│   ├── java/com/tva/
│   │   ├── Application.java         # Main application entry point
│   │   ├── WebSecurity.java         # Security configuration
│   │   ├── dto/                     # Data Transfer Objects
│   │   ├── entitiy/                 # JPA Entities
│   │   ├── exceptions/              # Custom exceptions
│   │   ├── mapper/                  # MapStruct mappers
│   │   ├── repositories/            # Spring Data JPA repositories
│   │   ├── service/                 # Business logic
│   │   ├── web/                     # REST controllers
│   ├── resources/
│       ├── application.properties   # Default application configuration
│       ├── application-dev.properties # Development-specific configuration
├── test/
│   ├── java/com/tva/                # Unit and integration tests
```

## Prerequisites

- Java 17
- Maven
- MySQL

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/tveleza2/G-store
cd stock-manager
```

### 2. Configure the Database

Update the `application-dev.properties` file in `src/main/resources` with your MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/g_store
spring.datasource.username=root
spring.datasource.password=your_password
```

### 3. Build and Run the Application

```bash
mvn clean install
mvn spring-boot:run
```

The application will start on `http://localhost:8081`.

### 4. Access the API Documentation

Visit `http://localhost:8081/swagger-ui.html` for the Swagger UI.

## API Endpoints

### Product Endpoints (TBD)

<!-- - **GET** `/api/products` - Retrieve all products
- **GET** `/api/products/{id}` - Retrieve a product by ID
- **POST** `/api/products` - Create a new product
- **PUT** `/api/products/{id}` - Update an existing product
- **DELETE** `/api/products/{id}` - Delete a product
- **PATCH** `/api/products/{id}/toggle` - Toggle product activation status -->

## Technologies Used

- **Spring Boot 3.0.2**
- **Spring Data JPA**
- **Spring Security**
- **MapStruct**
- **MySQL**
- **Lombok**
- **Swagger/OpenAPI**

## Testing

Run the tests using Maven:

```bash
mvn test
```

## License (TBD)

<!-- This project is licensed under the MIT License. See the `LICENSE` file for details. -->

## Contact

For questions or feedback, please contact [analyst.tva@gmail.com].
```

Feel free to customize the content further to suit your needs!