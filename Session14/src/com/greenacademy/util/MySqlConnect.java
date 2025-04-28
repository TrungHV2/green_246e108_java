package com.greenacademy.util;


import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnect {
    public static Connection getConnection() {
        try {
            // Chỉ định Driver tương ứng với hệ quản trị CSDL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Tạo đối tượng kết nối
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/Shop", "root", "root");
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
