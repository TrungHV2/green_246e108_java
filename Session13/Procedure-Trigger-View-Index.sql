use school;

DELIMITER //
CREATE PROCEDURE sp_get_hs_by_ma (in maHs varchar(36))
BEGIN
    -- Các câu lệnh SQL
    select * from tbl_hoc_sinh where ma_hs = maHS;
END //
DELIMITER ;

DELIMITER //
create procedure sp_count_hs (out cnt int)
begin
	set cnt = (select count(*) from tbl_hoc_sinh);
end //
DELIMITER ;
-- Gọi thủ tục

call sp_get_hs_by_ma('HS01');

set @cnt = 0;
call sp_count_hs(@cnt);
select @cnt;

create table test(
	id int auto_increment primary key,
    name varchar(50) not null unique
);
select * from test;
insert into test(name) values ('Tú');
delete from test where name in ('Nam','Tú');

truncate test;
-- VIEW
-- CREATE VIEW VIEW_NAME AS
-- SQL QUERY

create view vw_diem_hs as
select
hs.ma_hs, hs.ho_dem, hs.ten_hs,
sum(case when m.ma_mon = 1 then d.diem else null end) as 'Toán',
sum(case when m.ma_mon = 2 then d.diem else null end) as 'Vật lý',
sum(case when m.ma_mon = 3 then d.diem else null end) as 'Tin học',
sum(case when m.ma_mon = 4 then d.diem else null end) as 'Âm nhạc'
from tbl_hoc_sinh hs
join tbl_diem d on hs.ma_hs = d.ma_hs
join tbl_mon m on d.ma_mon = m.ma_mon
group by hs.ma_hs, hs.ho_dem, hs.ten_hs
;

select * from vw_diem_hs where ma_hs = 'HS01';

create index idx_hs_ten on tbl_hoc_sinh(ten_hs,ho_dem);

-- Trước index cost 0.85
-- Sau khi có index cost 0.35
select * from tbl_hoc_sinh where ten_hs = 'Nam';

-- DELIMITER //
-- CREATE TRIGGER trigger_name
-- {BEFORE | AFTER} {INSERT | UPDATE | DELETE}
-- ON table_name
-- FOR EACH ROW
-- BEGIN
--     -- Các câu lệnh SQL
-- END //
-- DELIMITER ;

use Shop;
DELIMITER //
create trigger trg_after_insert_HOADON
after insert on HOADON
for each row
begin
	update KHACHHANG set DOANHSO = DOANHSO + NEW.TRIGIA where MAKH = NEW.MAKH;
end //
DELIMITER ;

select * from KHACHHANG where MAKH='KH001';
insert into HOADON (SOHD, NGHD, MAKH, MANV, TRIGIA)
values ('HD016', '2023-01-05 09:15:00', 'KH001', 'NV001', 15000000);

INSERT INTO CTHD (SOHD, MASP, SL) VALUES ('HD016', 'SP007', 1);

-- Database: school
-- Tạo trriger cho hành động insert và update vào bảng điểm, 
-- nếu điểm không hợp lệ (0 <= diem <= 10) thì không được phép cập nhật vào bảng


-- Database: Shop
-- Tạo trigger cho bảng CTHD khi insert/update để cập nhật cột TRIGIA trên bảng HOADON
-- Trigger cho bảng HOADON để cập nhật bảng KHACHHANG(DOANHSO) khi TRIGIA thay đổi













