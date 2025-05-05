-- Bài tập 1: Phân tích dữ liệu cửa hàng bán sách
-- Đề bài
-- Bạn là nhà phân tích dữ liệu cho một cửa hàng bán sách. Cơ sở dữ liệu bookstore chứa thông tin về sách, khách hàng, và đơn hàng.

-- Yêu cầu phân tích
-- Học viên cần viết các câu lệnh SQL để trả lời các câu hỏi sau:

-- Liệt kê tất cả sách (tên sách, tác giả, danh mục) và tổng số lượng sách đã bán (dựa trên đơn hàng). Nếu sách chưa được bán, hiển thị số lượng bán là 0.
-- Tìm khách hàng đã chi tiêu nhiều nhất (tổng tiền = giá sách * số lượng) và hiển thị tên khách hàng, email, và tổng chi tiêu.
-- Đếm số đơn hàng theo từng danh mục sách trong tháng 1 năm 2025.
-- Tạo một stored procedure để lấy danh sách đơn hàng của một khách hàng cụ thể (nhận tham số là mã khách hàng) bao gồm tên sách, ngày đặt hàng, và tổng tiền (price * quantity).
-- Tạo một trigger để ghi log vào bảng order_log (cần tạo bảng này) mỗi khi có đơn hàng mới được thêm, lưu thông tin mã đơn hàng, mã khách hàng, ngày đặt hàng, và thời gian ghi log.
create database BookStore;
use BookStore;
create table Categories(
	id int auto_increment primary key,
    name varchar(50) unique not null
);
insert into Categories(name) values 
('Danh mục 4'),('Danh mục 5'),('Danh mục 6'),('Danh mục 7'),('Danh mục 8'),('Danh mục 9'),
('Danh mục 10'),('Danh mục 11'),('Danh mục 12'),('Danh mục 13'),('Danh mục 14'),('Danh mục 15');
select * from Categories
order by id asc
limit 3 offset 3
-- ((page - 1) * pageSize)
-- 0 (1), 3(2), 6(3), 9(4), 12(5), 15(6)
;
create table Books(
	bookId varchar(36) primary key not null,
	bookName varchar(250) not null unique,
    author varchar(250) not null,
    categoryId int not null,
    price float default(0),
    constraint FK_Books_Categories foreign key (categoryId) references Categories(id)
);
create table Customers(
	customerId int primary key auto_increment,
    fullName varchar(250) not null,
    email varchar(50),
    phone varchar(50),
    address varchar(250)
);
create table Orders(
	orderId int primary key auto_increment,
    customerId int not null,
    created datetime,
    status tinyint
);
create table OrderDetails(
	orderId int,
    bookId varchar(36),
    quantity int,
    price float,
    primary key(orderId,bookId),
    constraint FK_OrderDetails_Orders foreign key (orderId) references Orders(orderId),
    constraint FK_OrderDetails_Books foreign key (bookId) references Books(bookId)
);





-- Bài tập 2: Phân tích dữ liệu hệ thống quản lý nhân viên
-- Đề bài
-- Bạn là nhà phân tích dữ liệu cho một công ty. Cơ sở dữ liệu employee_management lưu trữ thông tin về nhân viên, phòng ban, và dự án.

-- Yêu cầu phân tích
-- Học viên cần viết các câu lệnh SQL để trả lời các câu hỏi sau:

-- Liệt kê tất cả nhân viên (tên, ngày tuyển dụng, tên phòng ban) và tổng số dự án họ tham gia. Nếu nhân viên không tham gia dự án, hiển thị số dự án là 0.
-- Tìm phòng ban có tổng lương cao nhất (tổng lương của tất cả nhân viên trong phòng ban) và hiển thị tên phòng ban cùng tổng lương.
-- Đếm số nhân viên được tuyển dụng trong năm 2023 theo từng phòng ban.
-- Tạo một stored procedure để lấy danh sách nhân viên có lương cao hơn một giá trị cụ thể (nhận tham số là mức lương tối thiểu) bao gồm tên nhân viên, tên phòng ban, và lương.
-- Tạo một trigger để ghi log vào bảng salary_log (cần tạo bảng này) mỗi khi lương của nhân viên được cập nhật, lưu thông tin mã nhân viên, lương cũ, lương mới, và thời gian cập nhật.