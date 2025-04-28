package com.greenacademy.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlExecutor {
    public static <T> List<T> execute(String sql, ThrowFunc<ResultSet, T> callback, Object... params) {
        List<T> result = new ArrayList<>();
        // B1: Tạo kết nối
        try (Connection conn = MySqlConnect.getConnection()) {
            // B2: Tạo đối tượng thực thi câu truy vấn
            PreparedStatement ps = conn.prepareStatement(sql);
            // B2.1: Truyền tham số cho cu truy vấn nếu có
            if (params != null)
                for (int i = 0; i < params.length; i++)
                    ps.setObject(i + 1, params[i]);
            // B3: Thực truy vấn
            ResultSet rs = ps.executeQuery();
            // B4: Đọc kết quả từ ResultSet
            while (rs.next()) {
                T entity = callback.apply(rs);
                if (entity != null)
                    result.add(entity);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static boolean execute(String sql, Object... params) {
        try (Connection conn = MySqlConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            if (params != null)
                for (int i = 0; i < params.length; i++)
                    ps.setObject(i + 1, params[i]);
            int result = ps.executeUpdate();
            return result == 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
