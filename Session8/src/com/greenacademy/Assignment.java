package com.greenacademy;

public class Assignment {
    public static void main(String[] args) {
        /**
         * Cho class
         * Product
         *      String productId; mã sp
         *      String productName; tên sản phẩm
         *      double price; giá sản phẩm
         *      int quantity; số lượng
         *      Provider provider; nhà cung cấp
         *
         * Provider
         *      String providerId; mã ncc
         *      String providerName; tên ncc
         *      String address; địa chỉ
         *      String phone; số điện thoại
         *
         * Viết chương chình quản lý kho gồm các yêu cầu sau
         *  1. Quản lý sản phẩm (thêm, sửa, xóa, hiển thị)
         *      - Thêm có check trùng productId, productName
         *      - Hiển thị dữ liệu dưới dạng bảng như sau
         *      +-------------+--------------+----------+----------+--------------+
         *      | Mã sản phẩm | Tên sản phẩm | Giá      | Số lượng | Nhà cung cấp |
         *      +-------------+--------------+----------+----------+--------------+
         *      | SP01        | Sản phẩm 1   | 5000     |       20 | Samsung      |
         *      | SP01        | Sản phẩm 1   | 5000     |       20 | Samsung      |
         *      | SP01        | Sản phẩm 1   | 5000     |       20 | Samsung      |
         *      +-------------+--------------+----------+----------+--------------+
         *  2. Quản lý nhà cung cấp (thêm, sửa, xóa, hiển thị)
         *      - Thêm có check trùng providerId, providerName
         *      - Xóa cần kiểm tra nếu ncc đang có sản phẩm thì không được xóa
         *      - Hiển thị dữ liệu dạng bảng tương tự Product gồm: Mã ncc, Tên ncc, Số lượng sp
         *      +--------+----------------+-------------+
         *      | Mã NCC | Tên NCC        | Số lượng sp |
         *      +--------+----------------+-------------+
         *      | NC01   | Samsung        |           3 |
         *      | NC02   | Iphone         |           0 |
         *      +--------+----------------+-------------+
         *  3. Nhập kho
         *  4. Xuất kho
         */
    }
}
