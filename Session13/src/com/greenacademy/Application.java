package com.greenacademy;

import java.sql.*;

public class Application {
    public static void main(String[] args) {
        try {
            // Chỉ định driver sử dụng với CSDL tương ứng
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Thông số kết nối database
            // Xử lý để đọc các thông tin kết nối databse từ config .env
            String host = AppConfig.getValue("host");
            String port = AppConfig.getValue("port");
            String database = AppConfig.getValue("database");
            String url = "jdbc:mysql://"+host+":"+port+"/"+database;
            String user = AppConfig.getValue("user");
            String password = AppConfig.getValue("password");
            // Tạo kết nối
            Connection conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connection successful");
            } else {
                System.out.println("Connection failed");
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
