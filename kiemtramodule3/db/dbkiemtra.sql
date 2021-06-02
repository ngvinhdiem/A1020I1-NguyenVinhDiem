drop database if exists client_management;
create database client_management;
use client_management;

create table mat_bang (
ma_mat_bang varchar(45) primary key not null,
trang_thai varchar(45) not null,
dien_tich int not null,
tang int not null,
loai_mat_bang varchar(45) not null,
gia_tien int not null,
ngay_bat_dau date not null,
ngay_ket_thuc date not null
);

insert into mat_bang
values ('AAA','Trong',21,8,'Chia Se',1100000,'2001-01-01','2002-02-02'),
('BBB','Ha Tang',21,8,'Tron Goi',1200000,'2001-01-01','2002-02-02'),
('CCC','Day Du',21,9,'Chia Se',1100000,'2001-01-01','2002-02-02'),
('DDD','Trong',21,9,'Tron Goi',1200000,'2001-01-01','2002-02-02');

DELIMITER $$
CREATE PROCEDURE insert_mat_bang(
IN ma_mat_bang varchar(45) ,
IN trang_thai varchar(45)  ,
IN dien_tich int  ,
IN tang int  ,
IN loai_mat_bang varchar(45)  ,
IN gia_tien int  ,
IN ngay_bat_dau date ,
IN ngay_ket_thuc date  
)
BEGIN
    INSERT INTO mat_bang VALUES(  ma_mat_bang  ,
 trang_thai   ,
 dien_tich   ,
 tang   ,
 loai_mat_bang  ,
 gia_tien   ,
 ngay_bat_dau  ,
 ngay_ket_thuc    );
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `get_mat_bang_by_id`(
	IN ma_mat_bang varchar(45)
)
BEGIN
SELECT * FROM mat_bang where mat_bang.ma_mat_bang=ma_mat_bang;
END$$
DELIMITER ;

select * from mat_bang;