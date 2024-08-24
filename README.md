# Makersharks - Manufacturer Search API

This project is a proof of concept for a search API that allows buyers to search for manufacturers based on customized requirements, such as location, nature of business, and manufacturing processes. The application is built using Spring Boot and MySQL.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Setup and Installation](#setup-and-installation)
- [API Endpoints](#api-endpoints)
- [Running the Application](#running-the-application)

## Prerequisites

Before you begin, ensure you have met the following requirements:

- **Java 17** or later installed
- **Maven** installed
- **MySQL** installed and running
- **Git** installed

## Setup and Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/chandu736/Makersharks_Assessment.git
    cd MakersharksApplication
    ```

2. Create a MySQL database.

3. Update the `application.properties` file with your MySQL credentials.

4. Build the project using Maven:

    ```bash
    mvn clean install
    ```

## API Endpoints

### Supplier Query

- **Endpoint:** `/api/supplier/query`  
- **Method:** `POST`  
- **Parameters:**  
    - `location`: The location of the manufacturers.
    - `natureOfBusiness`: The nature of the business (SMALL_SCALE, MEDIUM_SCALE, LARGE_SCALE).
    - `manufacturingProcesses`: The manufacturing process (MOULDING, PRINTING_3D, COATING, CASTING).
    - `limit`: The maximum number of results to return.
    - `offset`: The number of results to skip.
  
- **Example Request:**

    ```
    http://localhost:8080/api/supplier/query?location=Berlin&natureOfBusiness=MEDIUM_SCALE&manufacturingProcesses=PRINTING_3D&limit=10&offset=0
    ```

- **Example Response:**

    ```json
    [
        {
            "supplierId": "a0d8427f-6165-11ef-ae15-b48c9d6c3818",
            "companyName": "3D Print Solutions",
            "website": "https://3dprintsolutions.net",
            "location": "Berlin",
            "natureOfBusiness": "MEDIUM_SCALE",
            "manufacturingProcesses": [
                "COATING",
                "PRINTING_3D"
            ]
        }
    ]
    ```

## Running the Application

To run the application, use the following command:

    ```bash
    mvn spring-boot:run

Alternatively, you can run it in Eclipse IDE as a Spring Boot App:

Right-click on the project in Eclipse.
Select Run As -> Spring Boot App.
