create database school;
use school;
create table tbl_lop(
	ma_lop int auto_increment primary key,
    ten_lop varchar(50) not null unique
);
insert into tbl_lop(ten_lop) values ('12A1'),('12A2'),('12A3');
create table tbl_hoc_sinh(
	ma_hs varchar(36) primary key,
    ma_lop int not null,
    ho_dem varchar(100) not null,
    ten_hs varchar(100) not null,
    ngay_sinh date not null,
    dia_chi varchar(100) not null,
    foreign key (ma_lop) references tbl_lop(ma_lop)
);
insert into tbl_hoc_sinh(ma_hs,ma_lop,ho_dem,ten_hs,ngay_sinh,dia_chi) values
('HS01', 1,'Nguyễn Văn', 'Nam', '2000-04-25', 'Hà Nội'),
('HS02', 1,'Đoàn Văn', 'Thanh', '2000-04-25', 'Lạng Sơn'),
('HS03', 2,'Nguyễn Huy', 'Hùng', '2000-04-25', 'Bắc Ninh'),
('HS04', 2,'Nguyễn Duy', 'Phương', '1999-04-25', 'Bắc Ninh'),
('HS05', 3,'Trần Đức', 'Thành', '2002-04-25', 'Thái Nguyên'),
('HS06', 3,'Phan Hoàng', 'Sử', '2004-04-25', 'Phú Thọ');
create table tbl_mon (
	ma_mon int auto_increment primary key,
    ten_mon varchar(100) unique not null
);
insert into tbl_mon(ten_mon) values ('Toán'),('Vật lý'),('Tin học'),('Âm nhạc');
create table tbl_diem(
	ma_hs varchar(36) not null,
    ma_mon int not null,
    diem float check (diem >= 0 and diem <= 10),
    primary key (ma_hs,ma_mon),
    foreign key (ma_hs) references tbl_hoc_sinh(ma_hs),
    foreign key (ma_mon) references tbl_mon(ma_mon)
);
insert into tbl_diem (ma_hs,ma_mon,diem) values
('HS01',1,6),('HS01',2,8),('HS01',3,9),('HS01',4,7),
('HS02',1,6),('HS02',2,6),('HS02',3,5),('HS02',4,7),
('HS03',1,8),('HS03',2,8),('HS03',3,9),('HS03',4,7),
('HS04',1,4),('HS04',2,7),('HS04',3,7),('HS04',4,8),
('HS05',1,8),('HS05',2,8),('HS05',3,9),('HS05',4,9),
('HS06',1,9),('HS06',2,9),('HS06',3,8),('HS06',4,9);


-- Hiển thị danh sách bảng điểm của một học sinh
-- Kết quả: Họ tên, Toán, Vật lý, Tin học, Âm nhạc
select
hs.ma_hs, hs.ho_dem, hs.ten_hs,
sum(case when m.ma_mon = 1 then d.diem else null end) as 'Toán',
sum(case when m.ma_mon = 2 then d.diem else null end) as 'Vật lý',
sum(case when m.ma_mon = 3 then d.diem else null end) as 'Tin học',
sum(case when m.ma_mon = 4 then d.diem else null end) as 'Âm nhạc'
from tbl_hoc_sinh hs
join tbl_diem d on hs.ma_hs = d.ma_hs
join tbl_mon m on d.ma_mon = m.ma_mon
where hs.ma_hs='HS01'
group by hs.ma_hs, hs.ho_dem, hs.ten_hs
;

-- Hiển thị danh sách bảng điểm của một lớp
-- Kết quả: Họ tên, Toán, Vật lý, Tin học, Âm nhạc
select
l.ten_lop, hs.ma_hs, hs.ho_dem, hs.ten_hs,
sum(case when m.ma_mon = 1 then d.diem else null end) as 'Toán',
sum(case when m.ma_mon = 2 then d.diem else null end) as 'Vật lý',
sum(case when m.ma_mon = 3 then d.diem else null end) as 'Tin học',
sum(case when m.ma_mon = 4 then d.diem else null end) as 'Âm nhạc'
from tbl_hoc_sinh hs
join tbl_lop l on hs.ma_lop = l.ma_lop
join tbl_diem d on hs.ma_hs = d.ma_hs
join tbl_mon m on d.ma_mon = m.ma_mon
where l.ten_lop='12A1'
group by l.ten_lop, hs.ma_hs, hs.ho_dem, hs.ten_hs
;

-- Lấy danh sách xếp loại học sinh 
-- (TB >= 8 => Giỏi, 6.5 <= TB < 8 => Khá, TB < 6 => Trung bình)

 -- BTVN
 -- Thêm bảng thời khóa biểu gồm các cột ma_kb, ma_lop, ma_mon, thu, tiet
 -- Hiển thị danh sách thời khóa biểu của một lớp định dạng như sau
--  Tiết	Thứ 2	Thứ 3	Thứ 4	Thứ 5	Thứ 6	Thứ 7
-- Tiết 1	Toán					
-- Tiết 2	Vậy lý					
-- Tiết 3	Tin học					
-- Tiết 4	Âm nhạc					
-- Tiết 5	Hóa học					




























