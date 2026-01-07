CREATE DATABASE vehiclesSystem;
USE vehiclesSystem;

CREATE TABLE vehicles (
                          id VARCHAR(100),
                          model VARCHAR(100),
                          type VARCHAR(50),
                          PRIMARY KEY (id)
);
insert into vehicles values(1,"2003","car");