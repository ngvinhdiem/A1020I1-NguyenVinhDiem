drop database if exists student_management;
create database student_management	;

use student_management;
create table student (
id int primary key auto_increment, 
`name` varchar(50),
date_of_birth date
);

insert into student
values (1,'A','2020-12-12');
	
insert into student (`name`,date_of_birth) 
values ('B','2021-01-02'),('C','2019-01-01'),('D','2018-10-11');
select `name` from student
where id=1;

select `name` from student;
delete from student where id=3;

select * from student;
update student 
set `name`='E'
where id=4;
select * from student;
alter table student
add column `email` varchar(50);
insert into student (`name`,date_of_birth,`email`)
values ('F','1997-05-04','ldskj@sdfkld.com'),('G','2000-12-11','jsfld@sdklfj.com');

select id,name,date_of_birth from student;



