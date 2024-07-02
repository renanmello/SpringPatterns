# SpringPatterns

**SpringPatterns** is an API designed to test object-oriented design patterns using Spring Boot.

## Technologies Used

- **Java**: Version 17
- **Spring Boot**
  - Spring Web
  - Spring Data JPA
- **H2 Database**
- **OpenFeign**
- **OpenAPI**

## Features

- **Customer Registration API**: Automatically fills in the address based on the postal code using the viaCep API available at [https://viacep.com.br/](https://viacep.com.br/).

## Requirements

- Java 17
- Maven or Gradle

## Getting Started

### Prerequisites

Ensure you have the following installed:
- Java 17
- Maven or Gradle

### Installation

1. **Clone the Repository**
   ```sh
   git clone <repository_url>
   cd SpringPatterns
2. Build the Project

Using Maven:

mvn clean install

Using Gradle:

./gradlew build

3. Run the Application
4. 
Using Maven:

mvn spring-boot:run

Using Gradle:

    ./gradlew bootRun

API Endpoints
Customer Registration

    Get /customers
        Registers a new customer and automatically fills in the address using the viaCep API.
        Example request body:

      URL: viacep.com.br/ws/01001000/json/
      Example response:
      json

      {
      "cep": "01001-000",
      "logradouro": "Praça da Sé",
      "complemento": "lado ímpar",
      "unidade": "",
      "bairro": "Sé",
      "localidade": "São Paulo",
      "uf": "SP",
      "ibge": "3550308",
      "gia": "1004",
      "ddd": "11",
      "siafi": "7107"
    }
      
