

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    UNIQUE(username),
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


