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