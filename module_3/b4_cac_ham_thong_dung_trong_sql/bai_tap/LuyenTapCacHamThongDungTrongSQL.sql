drop database if exists  luyen_tap_cac_ham_thong_dung_trong_sql;
create database luyen_tap_cac_ham_thong_dung_trong_sql;
use luyen_tap_cac_ham_thong_dung_trong_sql;
create table hocvien(
id int,
`ten` varchar(50),
tuoi int,
`khoahoc` varchar(50),
sotien int
);
insert into hocvien 
values (1,'Hoang',21,'CNTT',400000),(2,'Viet',19,'DTVT',320000),(3,'Thanh',18,'KTDN',400000),(4,'Nhan',19,'CK',450000),(5,'Huong',20,'TCNH',500000),(5,'Huong',20,'TCNH',200000);

select * from hocvien;
select * from hocvien where `ten` = 'Huong';
select sum(sotien) 'Tongtiencuahuong' from hocvien where `ten`='Huong';
select distinct `ten` from hocvien;
