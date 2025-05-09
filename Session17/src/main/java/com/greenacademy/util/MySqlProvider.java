package com.greenacademy.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MySqlProvider {
    public static ResultSet execute(Connection conn, String sql, Object... params) {
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            return ps.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> execute(String sql, MyFunc<T> callback, Object... params) {
        List<T> list = new ArrayList<>();
        try (Connection conn = MySqlConnection.getConnect()){
            PreparedStatement ps = conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                T entity = callback.apply(rs);
                list.add(entity);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static int update(String sql, Object... params) {
        try (Connection conn = MySqlConnection.getConnect()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            if (sql.startsWith("INSERT")) {
                ps.executeUpdate();
                // Lấy ID tự tăng
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    System.out.println("ID tự tăng vừa chèn: " + generatedId);
                    return generatedId;
                }
            } else
                return ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}
