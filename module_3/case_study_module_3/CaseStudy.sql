drop database if exists case_study;
create database case_study;
use case_study;

create table ViTri (
IDViTri int primary key,
TenViTri varchar(45)
);

create table TrinhDo (
IDTrinhDo int primary key,
TrinhDo varchar(45)
);

create table BoPhan (
IDBoPhan int primary key,
BoPhan varchar(45)
);

create table NhanVien(
IDNhanVien int primary key,
HoTen varchar(45),
IDViTri int ,
IDTrinhDo int ,
IDBoPhan int ,
foreign key (IDViTri) references ViTri(IDViTri),
foreign key (IDTrinhDo) references TrinhDo(IDTrinhDo),
foreign key (IDBoPhan) references BoPhan(IDBoPhan),
NgaySinh date,
SoCMND varchar(45),
Luong varchar(45),
SDT varchar(45),
Email varchar(45),
DiaChi varchar(45)
);

create table LoaiKhach (
IDLoaiKhach int primary key,
TenLoaiKhach varchar(45)
);

create table KhachHang (
IDKhachHang int primary key,
IDLoaiKhach int,
FOREIGN KEY (IDLoaiKhach) references LoaiKhach(IDLoaiKhach),
HoTen varchar(45),
NgaySinh date,
SoCMND varchar(45),
SDT varchar(45),
Email varchar(45),
DiaChi varchar(45)
);


create table KieuThue (
IDKieuThue int primary key,
TenKieuThue varchar(45),
Gia int
);

create table LoaiDichVu (
IDLoaiDichVu int primary key,
TenLoaiDichVu varchar(45)
);

create table DichVu (
IDDichVu int primary key,
TenDichVu varchar(45),
DienTich int,
SoTang int,
SoNguoiToiDa int,
ChiPhiThue int,
IDKieuThue int,
IDLoaiDichVu int,
foreign key (IDKieuThue) references KieuThue(IDKieuThue),
foreign key (IDLoaiDichVu) references LoaiDichVu(IDLoaiDichVu), 
TrangThai varchar(45)
);

create table HopDong (
IDHopDong int primary key,
IDNhanVien int,
IDKhachHang int,
IDDichVu int,
foreign key (IDNhanVien) references NhanVien(IDNhanVien),
foreign key (IDKhachHang) references KhachHang(IDKhachHang),
foreign key (IDDichVu) references DichVu(IDDichVu),
NgayLamHopDong date,
NgayKetThuc date,
TienDatCoc int,
TongTien int
);

create table DichVuDiKem (
IDDichVuDiKem int primary key,
TenDichVuDiKem varchar(45),
Gia int,
DonVi int,
TrangThaiKhaDung varchar(45)
);

create table HopDongChiTiet (
IDHopDongChiTiet int primary key,
IDHopDong int,
IDDichVuDiKem int,
foreign key (IDHopDong) references HopDong(IDHopDong),
foreign key (IDDichVuDiKem) references DichVuDiKem(IDDichVuDiKem)
);

insert into ViTri 
values (1,'Le Tan'),(2,'Phuc Vu'),(3,'Chuyen Vien'),(4,'Giam Sat'),(5,'Quan Ly'),(6,'Giam Doc');

insert into TrinhDo
values (1,'Trung Cap'),(2,'Cao Dang'),(3,'Dai Hoc'),(4,'Sau Dai Hoc');

insert into BoPhan 
values (1,'Sale - Marketing'),(2,'Hanh Chinh'),(3,'Phuc Vu'),(4,'Quan Ly');



insert into NhanVien 
values (1,'Nguyen Van A',2,1,3,'1981-01-01','0001',2000000,'841','a@gmail.com','a street'),
		(2,'Nguyen Van B',1,2,1,'1982-01-01','0002',1000000,'842','b@gmail.com','b street'),
		(3,'Nguyen Van C',2,1,3,'1983-01-01','0003',2000000,'843','c@gmail.com','c street'),
		(4,'Nguyen Van D',6,4,4,'1984-01-01','0004',6000000,'844','d@gmail.com','d street'),
		(5,'Nguyen Van E',3,3,2,'1985-01-01','0005',3000000,'845','e@gmail.com','e street'),
		(6,'Nguyen Van F',4,3,4,'1986-01-01','0006',4000000,'846','f@gmail.com','f street'),
		(7,'Nguyen Van G',5,3,4,'1987-01-01','0007',5000000,'847','g@gmail.com','g street'),
		(8,'Nguyen Van H',2,1,3,'1988-01-01','0008',2000000,'848','h@gmail.com','h street'),
		(9,'Nguyen Van I',4,3,4,'1989-01-01','0009',4000000,'849','i@gmail.com','i street'),
		(10,'Nguyen Van J',5,4,4,'1990-01-01','0010',5000000,'850','j@gmail.com','j street'),
		(11,'Nguyen Van K',1,1,1,'1991-01-01','0011',1000000,'851','k@gmail.com','k street'),
		(12,'Nguyen Van L',3,2,2,'1992-01-01','0012',3000000,'852','l@gmail.com','l street'),
		(13,'Nguyen Van M',4,3,4,'1993-01-01','0013',4000000,'853','m@gmail.com','m street')
;

insert into LoaiKhach 
values (1,'Diamond'),(2,'Platinum'),(3,'Gold'),(4,'Silver'),(5,'Member')
;
select * from ViTri;
