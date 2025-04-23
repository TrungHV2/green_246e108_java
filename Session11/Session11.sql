-- Tạo cơ sở dữ liệu (CSDL)
create database Shop;
-- Xóa CSDL
drop database Shop;
-- Chọn database để tương tác
use Shop;
-- Tạo bảng
create table KHACHHANG (
	MAKH varchar(36) primary key,
    HOTEN varchar(100) not null,
    DCHI varchar(255),
    SODT varchar(20),
    NGSINH date,
    DOANHSO decimal(15,2) check (DOANHSO >= 0),
    NGDK date default (current_date)
);
create table NHANVIEN(
	MANV varchar(36),
    HOTEN varchar(100),
    NGVL date,
    SODT varchar(20),
    primary key (MANV)
);
create table SANPHAM (
	MASP varchar(36) primary key,
    TENSP varchar(512) unique not null,
    DVT varchar(50),
    NUOCSX varchar(100),
    GIA decimal(15,2)
);
create table HOADON (
	SOHD varchar(36) primary key,
    NGHD datetime,
    MAKH varchar(36),
    MANV varchar(36),
    TRIGIA decimal(15,2),
    foreign key (MAKH) references KHACHHANG(MAKH),
    foreign key (MANV) references NHANVIEN(MANV)
);
create table CTHD(
	SOHD varchar(36),
    MASP varchar(36),
    SL int,
    primary key (SOHD,MASP),
    foreign key (SOHD) references HOADON(SOHD),
    foreign key (MASP) references SANPHAM(MASP)
);
-- Xóa bảng
drop table KHACHHANG;
-- Cập nhật bảng
-- Đổi tên bảng
alter table KHACHHANG rename khach_hang;
-- Đổi thông tin cột (tên/kiểu dữ liệu)
alter table khach_hang change NGDK NGDK datetime;
-- Xóa khóa chính
alter table khach_hang drop primary key;
-- Thêm khóa chính
alter table khach_hang 
add constraint PK_MAKH primary key (MAKH);

-- DML
-- Thêm mới dữ liệu
-- KHACHHANG
INSERT INTO KHACHHANG (MAKH, HOTEN, DCHI, SODT, NGSINH, DOANHSO, NGDK) VALUES
('KH001', 'Nguyen Van A', '123 Le Loi, Q1, HCM', '0901234567', '1990-05-15', 15000000, '2020-01-10'),
('KH002', 'Tran Thi B', '45 Nguyen Hue, Q1, HCM', '0912345678', '1985-08-20', 8500000, '2020-03-05'),
('KH003', 'Le Van C', '78 Tran Hung Dao, Q5, HCM', '0987654321', '1992-11-30', 12000000, '2019-11-15'),
('KH004', 'Pham Thi D', '12 CMT8, Q3, HCM', '0978123456', '1988-04-25', 5000000, '2021-02-18'),
('KH005', 'Hoang Van E', '34 Ly Tu Trong, Q1, HCM', '0967890123', '1995-07-12', 9500000, '2021-05-22'),
('KH006', 'Vo Thi F', '56 Pasteur, Q3, HCM', '0934567890', '1982-09-08', 18000000, '2018-07-30');

-- NHAN VIEN
INSERT INTO NHANVIEN (MANV, HOTEN, NGVL, SODT) VALUES
('NV001', 'Tran Minh X', '2018-06-10', '0901111222'),
('NV002', 'Nguyen Thi Y', '2019-03-15', '0912222333'),
('NV003', 'Le Van Z', '2020-01-20', '0983333444'),
('NV004', 'Pham Hong A', '2017-11-05', '0974444555'),
('NV005', 'Hoang Ngoc B', '2021-02-28', '0965555666');

-- SANPHAM
INSERT INTO SANPHAM (MASP, TENSP, DVT, NUOCSX, GIA) VALUES
('SP001', 'Laptop Dell XPS 13', 'Chiếc', 'USA', 25000000),
('SP002', 'iPhone 13 Pro', 'Chiếc', 'USA', 28000000),
('SP003', 'Samsung Galaxy S22', 'Chiếc', 'Korea', 22000000),
('SP004', 'Sony WH-1000XM4', 'Chiếc', 'Japan', 6000000),
('SP005', 'Bose QuietComfort 35', 'Chiếc', 'USA', 5500000),
('SP006', 'Apple Watch Series 7', 'Chiếc', 'USA', 12000000),
('SP007', 'Dyson V11 Vacuum', 'Chiếc', 'UK', 15000000),
('SP008', 'LG OLED C1 TV', 'Chiếc', 'Korea', 35000000),
('SP009', 'Microsoft Surface Pro 8', 'Chiếc', 'USA', 28000000),
('SP010', 'Sony PlayStation 5', 'Chiếc', 'Japan', 14000000);

-- HOADON
INSERT INTO HOADON (SOHD, NGHD, MAKH, MANV, TRIGIA) VALUES
('HD001', '2023-01-05 09:15:00', 'KH001', 'NV001', 53000000),
('HD002', '2023-01-12 14:30:00', 'KH002', 'NV002', 28000000),
('HD003', '2023-01-18 10:45:00', 'KH003', 'NV003', 82000000),
('HD004', '2023-02-02 16:20:00', 'KH004', 'NV001', 11500000),
('HD005', '2023-02-10 11:10:00', 'KH005', 'NV004', 6000000),
('HD006', '2023-02-15 13:25:00', 'KH001', 'NV002', 35000000),
('HD007', '2023-03-03 15:40:00', 'KH002', 'NV003', 14000000),
('HD008', '2023-03-12 10:05:00', 'KH003', 'NV004', 28000000),
('HD009', '2023-03-20 09:30:00', 'KH004', 'NV005', 5500000),
('HD010', '2023-04-05 14:15:00', 'KH005', 'NV001', 12000000),
('HD011', '2023-04-12 11:50:00', 'KH006', 'NV002', 15000000),
('HD012', '2023-04-18 16:35:00', 'KH001', 'NV003', 25000000),
('HD013', '2023-05-02 10:20:00', 'KH002', 'NV004', 6000000),
('HD014', '2023-05-10 13:45:00', 'KH003', 'NV005', 28000000),
('HD015', '2023-05-15 15:10:00', 'KH004', 'NV001', 11500000);

-- CTHD
INSERT INTO CTHD (SOHD, MASP, SL) VALUES ('HD001', 'SP001', 1), ('HD001', 'SP004', 2), ('HD001', 'SP006', 1);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES ('HD002', 'SP002', 1), ('HD002', 'SP010', 1);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES ('HD003', 'SP008', 1), ('HD003', 'SP009', 1), ('HD003', 'SP003', 1);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES ('HD004', 'SP005', 1), ('HD004', 'SP007', 1);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES ('HD005', 'SP004', 1), ('HD005', 'SP005', 1);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES ('HD006', 'SP001', 1), ('HD006', 'SP006', 1), ('HD006', 'SP010', 1);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES ('HD007', 'SP010', 1), ('HD007', 'SP004', 1);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES ('HD008', 'SP002', 1), ('HD008', 'SP009', 1);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES ('HD009', 'SP005', 1), ('HD009', 'SP004', 1);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES ('HD010', 'SP006', 1), ('HD010', 'SP003', 1);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES ('HD011', 'SP007', 1), ('HD011', 'SP001', 1), ('HD011', 'SP005', 1);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES ('HD012', 'SP001', 1), ('HD012', 'SP003', 1);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES ('HD013', 'SP004', 1), ('HD013', 'SP005', 1);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES ('HD014', 'SP002', 1), ('HD014', 'SP009', 1);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES ('HD015', 'SP005', 1), ('HD015', 'SP007', 1), ('HD015', 'SP010', 1);
-- Sửa dữ liệu
update KHACHHANG 
set NGSINH = '1995-05-13' -- yyyy-MM-dd
where MAKH='KH01';
-- Xóa dữ liệu
delete from KHACHHANG where MAKH='KH01';

-- TRUY VẤN DỮ LIỆU
-- select 
-- thông tin cần lấy ra (* để lấy tất cả)
-- from
-- join
-- where
-- group by
-- having
-- order by
--  lấy tất cả bản ghi trong bảng khach_hang
select * from KHACHHANG; 
-- Lấy các khách hàng ở HCM
select * from KHACHHANG where DCHI = 'HCM';
-- Đếm số khách hàng ở các tỉnh/thành sắp xếp tăng dần
select DCHI, count(*) as total from KHACHHANG 
group by DCHI
-- having total > 1
order by total asc
;
select distinct DCHI from KHACHHANG; 
select * from KHACHHANG where HOTEN like 'Nguyễn%';
select * from KHACHHANG where HOTEN like '%Văn%';
select * from KHACHHANG 
-- where DOANHSO between 2000000 and 3000000;
where DOANHSO >= 2000000 AND DOANHSO <= 3000000;

-- BTVN
-- Yêu cầu truy vấn dữ liệu
-- 1. Lấy danh sách sản phẩm sắp xếp theo giá tăng dần
-- 2. Lấy danh sách khách hàng có ngày đăng ký từ năm 2023 đến nay
-- 3. Lấy danh sách đơn hàng gồm (SOHD,NGHD,TENKH,TENNV,TRIGIA)
-- 4. Lấy danh sách hóa đơn trong tháng 4 năm 2025
-- 5. Lấy danh sách 2 sản phẩm bán chạy nhất
-- 6. Lấy danh sách 3 khách hàng có nhiều đơn hàng nhất













