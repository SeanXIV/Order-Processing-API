# Order Processing System

## Description
The Order Processing System is a backend application designed to handle order processing for an e-commerce platform. It includes functionalities for creating orders, updating order status, and retrieving order history.

## Technologies Used
- Java 17
- Spring Boot
- Hibernate (JPA)
- H2 Database (for testing purposes)
- Maven

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Maven 3.6.0 or higher

### Installation
1. Clone the repository:
    ```bash
    git clone https://github.com/SeanXIV/Order-Processing-API.git
    ```
2. Navigate to the project directory:
    ```bash
    cd order-processing-system
    ```
3. Build the project using Maven:
    ```bash
    mvn clean install
    ```

### Running the Application
1. Run the Spring Boot application:
    ```bash
    mvn spring-boot:run
    ```
2. The application will start on `http://localhost:8080`.

## API Endpoints

### Create a New Order
- **Method:** POST
- **URL:** `/api/orders`
- **Headers:**
    - `Content-Type: application/json`
- **Body (JSON):**
    ```json
    {
      "customer": "John Doe",
      "items": ["item1", "item2"],
      "status": "PENDING"
    }
    ```
- **Expected Response:**
    - **Status:** 201 Created
    - **Body:**
      ```json
      {
        "id": 1,
        "customer": "John Doe",
        "items": ["item1", "item2"],
        "status": "PENDING",
        "orderDate": "2025-01-10T09:00:00"
      }
      ```

### Retrieve All Orders
- **Method:** GET
- **URL:** `/api/orders`
- **Expected Response:**
    - **Status:** 200 OK
    - **Body:**
      ```json
      [
        {
          "id": 1,
          "customer": "John Doe",
          "items": ["item1", "item2"],
          "status": "PENDING",
          "orderDate": "2025-01-10T09:00:00"
        }
      ]
      ```

### Retrieve a Specific Order
- **Method:** GET
- **URL:** `/api/orders/{id}`
- **Expected Response:**
    - **Status:** 200 OK
    - **Body:**
      ```json
      {
        "id": 1,
        "customer": "John Doe",
        "items": ["item1", "item2"],
        "status": "PENDING",
        "orderDate": "2025-01-10T09:00:00"
      }
      ```

### Update Order Status
- **Method:** PUT
- **URL:** `/api/orders/{id}`
- **Headers:**
    - `Content-Type: application/json`
- **Body (JSON):**
    ```json
    {
      "status": "COMPLETED"
    }
    ```
- **Expected Response:**
    - **Status:** 200 OK
    - **Body:**
      ```json
      {
        "id": 1,
        "customer": "John Doe",
        "items": ["item1", "item2"],
        "status": "COMPLETED",
        "orderDate": "2025-01-10T09:00:00"
      }
      ```

### Delete an Order
- **Method:** DELETE
- **URL:** `/api/orders/{id}`
- **Expected Response:**
    - **Status:** 200 OK
    - **Body:**
      ```json
      "Order deleted successfully with ID: 1"
      ```

### Retrieve Order History
- **Method:** GET
- **URL:** `/api/orders/history`
- **Query Parameters:** `customer`
- **Expected Response:**
    - **Status:** 200 OK
    - **Body:**
      ```json
      [
        {
          "id": 1,
          "customer": "John Doe",
          "items": ["item1", "item2"],
          "status": "PENDING",
          "orderDate": "2025-01-10T09:00:00"
        }
      ]
      ```

## Contact
For any questions or feedback, please contact [andrewseanego14@gmail.com](mailto:your-email@example.com).
