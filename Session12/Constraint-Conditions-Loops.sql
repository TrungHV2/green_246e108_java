use Shop;
-- Thêm ràng buộc không được bỏ trống
alter table KHACHHANG
modify column HOTEN varchar(100) not null;
-- Thêm giá trị mặc định
alter table KHACHHANG
modify column NGDK date default (current_date);
-- Thêm điều kiện check giá trị đầu vào
alter table KHACHHANG
add constraint CHK_DS check (DOANHSO >= 0);
-- Thêm ràng buộc unique (không trùng lặp giá trị)
alter table SANPHAM
modify column TENSP varchar(512) unique;

alter table HOADON
add column TRANGTHAI bool default(0);

select * from KHACHHANG;
INSERT INTO KHACHHANG (MAKH, HOTEN, DCHI, SODT, NGSINH, DOANHSO) VALUES
('KH008', 'Hoàng Văn Trung', '123 Le Loi, Q1, HCM', '0901234567', '1990-05-15', 0)
;

INSERT INTO SANPHAM (MASP, TENSP, DVT, NUOCSX, GIA) VALUES
('SP011', 'Laptop Dell Vostro', 'Chiếc', 'USA', 25000000)
;




-- Xử lý logic
-- IF điều_kiên THEN
-- 	-- câu lệnh
-- ELSEIF điều_Kiện THEN
-- 	-- câu lệnh
-- ELSE
-- 	-- Câu lệnh
--     
-- END IF;

-- CASE biểu thức
-- 	WHEN giá trị so sánh THEN kết quả 1
-- 	WHEN giá trị so sánh THEN kết quả 2
-- 	WHEN giá trị so sánh THEN kết quả 3
--  ELSE kết quả mặc định
-- END
update HOADON set TRANGTHAI=1 where SOHD in ('HD003','HD004','HD005');
select SOHD, NGHD, MAKH,MANV,TRIGIA,
case TRANGTHAI
	when 1 then 'Đã thanh toán'
    when 0 then 'Chưa thanh toán'
    else 'N/A'
end as TRANG_THAI
 from HOADON;



DELIMITER //
CREATE PROCEDURE display_name()
BEGIN
    -- Khai báo biến
    DECLARE txtName VARCHAR(100);
    -- Gán giá trị cho biến
    SET txtName = 'Hoàng Văn Trung';
    -- Hiển thị kết quả
    SELECT txtName AS name;
END //
DELIMITER ;

-- Gọi procedure để xem kết quả
CALL display_name();

DROP PROCEDURE cursor_example;
DELIMITER //
CREATE PROCEDURE cursor_example()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE txtTen VARCHAR(100);
    DECLARE money decimal(15,2);
    declare total decimal(15,2) default 0;
    DECLARE cur CURSOR FOR SELECT DOANHSO FROM KHACHHANG;
    
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    OPEN cur;
    read_loop: LOOP
        FETCH cur INTO money;
        IF done THEN
            LEAVE read_loop;
        END IF;
        -- Xử lý dữ liệu
        set total = total + money;
        -- SELECT CONCAT('Xử lý khách hàng: ', txtTen);
    END LOOP;
    SELECT total;
    CLOSE cur;
END //
DELIMITER ;
CALL cursor_example();
select sum(DOANHSO) from KHACHHANG;

