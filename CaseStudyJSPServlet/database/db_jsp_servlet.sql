drop database if exists db_jsp_servlet;
create database db_jsp_servlet;
use db_jsp_servlet;

create table `position`(
	position_id int primary key not null,
    position_name varchar(45) not null
);

insert into `position` 
values (1,'Le Tan'),(2,'Phuc Vu'),(3,'Chuyen Vien'),(4,'Giam Sat'),(5,'Quan Ly'),(6,'Giam Doc');

create table education_degree(
	education_degree_id int primary key not null,
    education_degree_name varchar(45) not null
);

insert into education_degree 
values (1,'Trung Cap'),(2,'Cao Dang'),(3,'Dai hoc'),(4,'Sau Dai Hoc');

create table division(
	division_id int primary key not null,
    division_name varchar(45) not null
);

insert into division
values (1,'Sale-Marketing'),(2,'Hanh Chinh'),(3,'Phuc Vu'),(4,'Quan Ly');

create table `user`(
	username varchar(255) primary key not null,
    `password` varchar(255) not null
);

create table `role`(
	role_id int primary key not null,
    role_name varchar(255) not null
);

create table user_role(
	role_id int not null,
    username varchar(255) not null,
    
    foreign key (username) references user(username),
    foreign key (role_id) references role(role_id)
);




create table employee(
	employee_id int primary key not null,
    employee_name varchar(45) not null,
    employee_birthday date not null,
    employee_id_card varchar(45) not null,
    employee_salary double not null,
    employee_phone varchar(45) not null,
    employee_email varchar(45) not null,
    employee_address varchar(45) not null,
    position_id int not null,
    education_degree_id int not null,
    division_id int not null,
--     username varchar(255) not null,
    
    foreign key (position_id) references `position`(position_id),
    foreign key (education_degree_id) references education_degree(education_degree_id),
    foreign key (division_id) references division(division_id)
--     foreign key (username) references user(username)
);

insert into employee 
values (1,'A','2001-01-01','1A',10,'001','a@gmail.com','a street',1,1,1),
(2,'B','2002-02-02','2B',20,'002','b@gmail.com','b street',2,2,2),
(3,'C','2003-03-03','3C',30,'003','c@gmail.com','c street',3,3,3),
(4,'D','2004-04-04','4D',40,'004','d@gmail.com','d street',4,4,4)
;

DELIMITER $$
CREATE PROCEDURE insert_employee(
	IN employee_id int   ,
    IN employee_name varchar(45)  ,
    IN employee_birthday date  ,
   IN  employee_id_card varchar(45)  ,
    IN employee_salary double  ,
    IN employee_phone varchar(45)  ,
    IN employee_email varchar(45)  ,
    IN employee_address varchar(45)  ,
    IN position_id int  ,
    IN education_degree_id int  ,
    IN division_id int
)
BEGIN
    INSERT INTO employee VALUES( employee_id    ,
     employee_name   ,
     employee_birthday   ,
     employee_id_card   ,
     employee_salary   ,
     employee_phone   ,
     employee_email   ,
     employee_address  ,
     position_id   ,
     education_degree_id   ,
		division_id );
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE update_employee(
	IN employee_id int   ,
    IN employee_name varchar(45)  ,
    IN employee_birthday date  ,
   IN  employee_id_card varchar(45)  ,
    IN employee_salary double  ,
    IN employee_phone varchar(45)  ,
    IN employee_email varchar(45)  ,
    IN employee_address varchar(45)  ,
    IN position_id int  ,
    IN education_degree_id int  ,
    IN division_id int
)
BEGIN
UPDATE employee SET employee.employee_name=employee_name,employee.employee_birthday=employee_birthday,employee.employee_id_card=employee_id_card,
employee.employee_salary=employee_salary,employee.employee_phone=employee_phone,employee.employee_email=employee_email,
employee.employee_address=employee_address,employee.position_id=position_id,employee.education_degree_id=education_degree_id,
employee.division_id=division_id
WHERE employee.employee_id=employee_id;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `get_employee_by_id`(
	IN employee_id int
)
BEGIN
SELECT * FROM employee where employee.employee_id=employee_id;
END$$
DELIMITER ;


select * from employee;

create table customer_type(
	customer_type_id int primary key not null,
    customer_type_name varchar(45) not null
);


create table customer(
	customer_id int primary key not null,
    customer_type_id int not null,
    customer_name varchar(45) not null,
    customer_birthday date not null,
    customer_gender bit(1) not null,
    customer_id_card varchar(45) not null,
    customer_phone varchar(45) not null,
    customer_email varchar(45) not null,
    customer_address varchar(45) not null,
    
    foreign key (customer_type_id) references customer_type(customer_type_id)
);



create table service_type(
	service_type_id int primary key not null,
    service_type_name varchar(45) not null
);

insert into service_type 
values (1,'Villa'),(2,'House'),(3,'Room');

select * from service_type;

create table rent_type(
	rent_type_id int primary key not null,
    rent_type_name varchar(45) not null,
    rent_type_cost double not null
);

insert into rent_type
values (1,'Nam',120),(2,'Thang',60),(3,'Ngay',40),(4,'Gio',30);
select * from rent_type;

create table service(
	service_id int primary key not null,
    service_name varchar(45) not null,
    service_area int not null,
    service_cost double not null,
    service_max_people int not null,
    rent_type_id int not null,
    service_type_id int not null,
    standard_room varchar(45) not null,
    description_other_convenience varchar(45) not null,
    pool_area double not null,
    number_of_floors int not null,
    foreign key (rent_type_id) references rent_type(rent_type_id),
    foreign key (service_type_id) references service_type(service_type_id)
);

insert into service
values (1,'Aaa',10,10,10,1,1,'AAA','AAa',10,10),(2,'Bbb',20,20,20,2,2,'BBB','BBb',20,20),(3,'Ccc',30,30,30,3,3,'CCC','CCc',30,30);
select * from service;

DELIMITER $$
CREATE PROCEDURE insert_service(
	IN service_id int ,
    IN service_name varchar(45) ,
    IN service_area int ,
    IN service_cost double,
    IN service_max_people int ,
    IN rent_type_id int ,
   IN  service_type_id int ,
    IN standard_room varchar(45) ,
    IN description_other_convenience varchar(45),
    IN pool_area double ,
    IN number_of_floors int 
)
BEGIN
    INSERT INTO service VALUES(service_id,service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,
    standard_room,description_other_convenience,pool_area,number_of_floors);
END$$
DELIMITER ;

call insert_service(4,'DDd',40,40,40,4,1,'DDD','DDd',40,40);
select * from service;

DELIMITER $$
CREATE PROCEDURE update_service(
	IN service_id int ,
    IN service_name varchar(45) ,
    IN service_area int ,
    IN service_cost double,
    IN service_max_people int ,
    IN rent_type_id int ,
   IN  service_type_id int ,
    IN standard_room varchar(45) ,
    IN description_other_convenience varchar(45),
    IN pool_area double ,
    IN number_of_floors int 
)
BEGIN
UPDATE service SET service.service_name=service_name,service.service_area=service_area,service.service_cost=service_cost,
service.service_max_people=service_max_people,service.rent_type_id=rent_type_id,service.service_type_id=service_type_id,
service.standard_room=standard_room,service.description_other_convenience=description_other_convenience,
service.pool_area=pool_area,service.number_of_floors=number_of_floors
WHERE service.service_id=service_id;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `get_service_by_id`(
	IN service_id int
)
BEGIN
SELECT * FROM service where service.service_id=service_id;
END$$
DELIMITER ;

-- call update_service(4,'DDdUpdated',40,40,40,4,1,'DDD','DDd',40,40); 
-- select * from service;
create table contract(
	contract_id int primary key not null,
    contract_start_date datetime not null,
    contract_end_date datetime not null,
    contract_daposit double not null,
    contract_total_money double not null,
    employee_id int not null,
    customer_id int not null,
    service_id int not null,
    
    foreign key (employee_id) references employee(employee_id),
    foreign key (customer_id) references customer(customer_id),
    foreign key (service_id) references service(service_id)
);

create table attach_service(
	attach_service_id int primary key not null,
    attach_service_name varchar(45) not null,
    attach_service_cost double not null,
    attach_service_unit int not null,
    attach_service_status varchar(45) not null
);

create table contract_detail(
	contract_detail_id int primary key not null,
    contract_id int not null,
    attach_service_id int not null,
    quantity int not null,
    
    foreign key (contract_id) references contract(contract_id),
	foreign key (attach_service_id) references attach_service(attach_service_id)
);

insert into customer_type 
values (1,'Diamond'),
(2,'Gold'),
(3,'Member'),
(4,'Silver');

insert into customer
value (1, 1, 'A', '2001-01-01', 1, 'a1' , '1111', 'a@gmail.com', 'a street'),
(2, 2, 'B', '2002-02-02', 0, 'b2' , '2222', 'b@gmail.com', 'b street'),
(3, 3, 'C', '2003-03-03', 1, 'c3' , '3333', 'c@gmail.com', 'c street'),
(4, 4, 'D', '2004-04-04', 0, 'd4' , '4444', 'd@gmail.com', 'd street');

select * from customer;

DELIMITER $$
CREATE PROCEDURE insert_customer(
		IN customer_id int,
    IN customer_type_id int,
    IN customer_name varchar(45),
    IN customer_birthday date,
    IN customer_gender bit(1),
    IN customer_id_card varchar(45),
    IN customer_phone varchar(45), 
    IN customer_email varchar(45),
    IN customer_address varchar(45) 
)
BEGIN
    INSERT INTO customer(customer_id,customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,
    customer_email,customer_address) VALUES(customer_id,customer_type_id,customer_name,customer_birthday,customer_gender,
    customer_id_card,customer_phone, customer_email,customer_address);
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE update_customer(
	IN customer_id int,
    IN customer_type_id int,
    IN customer_name varchar(45),
    IN customer_birthday date,
    IN customer_gender bit(1),
    IN customer_id_card varchar(45),
    IN customer_phone varchar(45), 
    IN customer_email varchar(45),
    IN customer_address varchar(45) 
)
BEGIN
update customer set customer.customer_type_id= customer_type_id,customer.customer_name =customer_name,customer.customer_birthday=customer_birthday,
customer.customer_gender=customer_gender,customer.customer_id_card=customer_id_card,customer.customer_phone=customer_phone,customer.customer_email=customer_email,
customer.customer_address=customer_address
where customer.customer_id = customer_id;
END$$
DELIMITER ;


call insert_customer(5, 1, 'E', '2005-05-05', 1, 'e5' , '5555', 'e@gmail.com', 'e street');
select * from customer;
call update_customer(5, 1, 'EE', '2005-05-05', 1, 'e5' , '5555', 'e@gmail.com', 'e street');
select * from customer;

DELIMITER $$
CREATE PROCEDURE `get_customer_by_id`(
	IN customer_id int
)
BEGIN
SELECT * FROM customer where customer.customer_id=customer_id;
END$$
DELIMITER ;


