# Airline Reservation System

## Overview
The **Airline Reservation System** is a Java-based application designed to facilitate efficient booking, management, and cancellation of flights. This system allows users to register, log in, and make flight reservations while enabling employees to manage flight details seamlessly. Built using Core Java, Swing for the user interface, and MySQL for the database, this project demonstrates robust software development principles and a clear understanding of object-oriented programming.

## Features
- **User Registration and Login**: Secure user authentication with role-based access (regular users and employees).
- **Flight Management**: Employees can add new flights, update existing flight details, and manage available seats.
- **Reservation Management**: Users can book flights and cancel reservations with automatic seat updates.
- **Database Integration**: Utilizes MySQL to store user, flight, and reservation data, ensuring data persistence and integrity.

## Technology Stack
- **Programming Language**: Java
- **User Interface**: Swing (Java GUI)
- **Database**: MySQL
- **Build Tool**: Maven (optional for dependency management)

## Getting Started

### Prerequisites
- **Java Development Kit (JDK)**: Ensure JDK 8 or higher is installed.
- **MySQL**: Install MySQL Server and MySQL Workbench.
- **Database Setup**: Create a database named `airline_reservation_system` and run the SQL scripts provided in the `database.sql` file to set up the necessary tables.
- **IDE**: Use any Java IDE (Eclipse, IntelliJ IDEA, or NetBeans) for development and testing.

### Database Configuration
Update the `DatabaseConnection.java` file with your database credentials:

```java
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/airline_reservation_system";
    private static final String USER = "your_username"; // Replace with your username
    private static final String PASSWORD = "your_password"; // Replace with your password
}

## Execute the following SQL commands in MySQL Workbench:

```sql
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100),
    role VARCHAR(50)
);

CREATE TABLE flights (
    id INT PRIMARY KEY AUTO_INCREMENT,
    flight_number VARCHAR(50) NOT NULL,
    departure VARCHAR(255),
    destination VARCHAR(255),
    time TIMESTAMP,
    available_seats INT
);

CREATE TABLE reservations (
    id INT PRIMARY KEY AUTO_INCREMENT,
    flight_id INT,
    user_id INT,
    status VARCHAR(50),
    FOREIGN KEY (flight_id) REFERENCES flights(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

## Running the Application

1. Clone the repository to your local machine:

    ```bash
    git clone https://github.com/yourusername/airline-reservation-system.git
    cd airline-reservation-system
    ```

2. Compile and run the application in your IDE.

3. Launch the main application window to start interacting with the system.

## Usage

- **User Registration**: New users can register by providing their username, password, email, and role.
- **Employee Functions**: Employees can log in to add or update flight details and manage reservations.
- **User Functions**: Regular users can log in to book and cancel flights.

## Deployment

This project can be deployed on Render or similar platforms. Ensure that the database is accessible and environment variables are set correctly for the application to connect to the database seamlessly.

## Contributions

Contributions are welcome! Feel free to submit a pull request for enhancements or bug fixes.
## License

This project is licensed under the MIT License - see the [LICENSE](https://github.com/Namra7789/Airline-Reservation-System?tab=readme-ov-file#:~:text=License-,MIT%20license,-Activity) file for details.
