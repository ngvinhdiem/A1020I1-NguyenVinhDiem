drop database if exists tao_khoa_ngoai;
create database tao_khoa_ngoai;
use tao_khoa_ngoai;
CREATE TABLE customers(
   id INT AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(40),
   address VARCHAR(255),
   email VARCHAR(255)
);
CREATE TABLE orders(
   id INT AUTO_INCREMENT,
   staff VARCHAR(50),
   PRIMARY KEY(id),
   customer_id INT,
   --  customer_id INT FOREIGN KEY REFERENCES customers(id)
   FOREIGN KEY (customer_id) REFERENCES customers(id)
);


