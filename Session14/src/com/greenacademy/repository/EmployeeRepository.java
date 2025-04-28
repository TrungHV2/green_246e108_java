package com.greenacademy.repository;

import com.greenacademy.entity.EmployeeEntity;
import com.greenacademy.util.SqlExecutor;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    public List<EmployeeEntity> findAll() {
        List<EmployeeEntity> list = new ArrayList<>();
        String sql = "select * from NHANVIEN";
        list = SqlExecutor.execute(sql, rs -> {
            EmployeeEntity employee = new EmployeeEntity();
            employee.setEmployeeId(rs.getString("MANV"));
            employee.setStartDate(rs.getTimestamp("NGVL"));
            return employee;
        });
//        //Connection conn = null;
//        PreparedStatement pstmt = null;
//        try (Connection conn = MySqlConnect.getConnection()) {
//            //conn = MySqlConnect.getConnection();
//            pstmt = conn.prepareStatement("select * from NHANVIEN");
//            ResultSet rs = pstmt.executeQuery();
//            while (rs.next()) {
//                EmployeeEntity employee = new EmployeeEntity();
//                employee.setEmployeeId(rs.getString("MANV"));
//                employee.setStartDate(rs.getTimestamp("NGVL"));
//                list.add(employee);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
        return list;
    }

    public  EmployeeEntity findId(String id) {
        String sql = "select * from NHANVIEN where MANV = ?";
        EmployeeEntity employeeEntity = SqlExecutor.execute(sql, rs -> {
            EmployeeEntity employee = new EmployeeEntity();
            employee.setEmployeeId(rs.getString("MANV"));
            employee.setStartDate(rs.getTimestamp("NGVL"));
            return employee;
        }, id).getFirst();
        return employeeEntity;
    }

    public boolean save(EmployeeEntity employee) {
        String sql = "INSERT INTO NHANVIEN (MANV,HOTEN,NGVL,SODT) VALUES (?,?,?,?)";
        Object[] params = new Object[] {
                employee.getEmployeeId(),
                employee.getEmployeeName(),
                employee.getStartDate(),
                employee.getPhone()
        };
        return SqlExecutor.execute(sql, params);

//        PreparedStatement pstmt = null;
//        try (Connection conn = MySqlConnect.getConnection()) {
//            pstmt = conn.prepareStatement("INSERT INTO NHANVIEN (MANV,HOTEN,NGVL,SODT) VALUES (?,?,?,?)");
//            pstmt.setObject(1, employee.getEmployeeId());
//            pstmt.setString(2, employee.getEmployeeName());
//            pstmt.setObject(3, employee.getStartDate());
//            pstmt.setObject(4, employee.getPhone());
//            int result = pstmt.executeUpdate();
//            return result == 1;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return false;
//        }
    }
}
