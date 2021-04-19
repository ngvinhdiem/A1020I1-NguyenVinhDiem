create database phan_tich_va_thiet_ke_csdl;
use phan_tich_va_thiet_ke_csdl;
create table customers (
customerNumber int not null,
`customerName` varchar(50) not null,
`contactLastName` varchar(50) not null,
`contactFirstName` varchar(50) not null,
`phone` varchar(50) not null,
`addressLine1` varchar(50) not null,
`addressLine2` varchar(50) ,
`city` varchar(50) not null,
`state` varchar(50) not null,
`postalCode` varchar(15) not null,
`country` varchar(50) not null,
creditLimit double,
salesRepEmployeeNumber int not null,
FOREIGN KEY (salesRepEmployeeNumber) references employees(employeeNumber)
);

create table orders (
orderNumber int not null,
orderDate date not null,
requiredDate date not null,
shippedDate date not null,
`status` varchar(15) not null,
comments text not null,
quantityOrdered int not null,
priceEach double not null,
customerNumber int not null,
 FOREIGN KEY (customerNumber) references customers(customerNumber)
);

create table payments (
	customerNumber int,
    FOREIGN KEY (customerNumber) references customers(customerNumber),
	`checkNumber` varchar(50) not null,
    paymentDate date not null,
    amount double not null
);

create table products (
	`productCode` varchar(15) not null,
	`productName` varchar(70) not null,
	`productScale` varchar(10) not null,
	`productVendor` varchar(50) not null,
    productDescription text not null,
    quantityInStock int not null,
    buyPrice double not null,
    MSRP double not null
);

create table productlines (
`productLine` varchar(50) not null,
textDescription text,
image text
);

create table offices (
`officeCode` varchar(10) not null,
`city` varchar(50) not null,
`phone` varchar(50) not null,
`addressLine1` varchar(50) not null,
`addressLine2` varchar(50) ,
`state` varchar(50) ,
`country` varchar(50) ,
`postalCode` varchar(15) 
);

create table employees (
employeeNumber int not null,
`lastName` varchar(50) not null,
`firstName` varchar(50) not null,
`email` varchar(100) not null,
`jobTitle` varchar(50) not null,
`officeCode` varchar(10) not null,
 FOREIGN KEY (`officeCode`) references offices(`officeCode`),
 FOREIGN KEY (reportTo) references employees(reportTo)
 
);



