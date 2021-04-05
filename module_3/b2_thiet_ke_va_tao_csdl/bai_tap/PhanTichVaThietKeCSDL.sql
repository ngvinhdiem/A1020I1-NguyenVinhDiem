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
creditLimit double
);

create table orders (
orderNumber int not null,
orderDate date not null,
requiredDate date not null,
shippedDate date not null,
`status` varchar(15) not null,
comments text not null,
quantityOrdered int not null,
priceEach double not null
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