package com.greenacademy;

import com.greenacademy.entity.EmployeeEntity;
import com.greenacademy.repository.EmployeeRepository;
import com.greenacademy.util.MySqlConnect;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;

public class Application {
    public static void main(String[] args) {
//        Connection con = MySqlConnect.getConnection();
//        if (con != null) {
//            System.out.println("Connecting to the database successfully!");
//        } else {
//            System.out.println("Connecting to the database failed!");
//        }
        EmployeeRepository employeeRepository = new EmployeeRepository();

        EmployeeEntity employee = new EmployeeEntity();
//        NV005	Hoang Ngoc B	2021-02-28	0965555666
        employee.setEmployeeId("NV006");
        employee.setEmployeeName("JDBC");
        employee.setStartDate(Timestamp.valueOf("2021-02-28 00:00:00"));
        employee.setPhone("123456789");
        // employeeRepository.save(employee);


        List<EmployeeEntity> employeeList = employeeRepository.findAll();

        for (EmployeeEntity emp : employeeList) {
            System.out.println(emp.getEmployeeId());
            System.out.println(emp.getStartDate());
        }

        System.out.println("Tìm id = NV001");
        EmployeeEntity employee2 = employeeRepository.findId("NV001");
        System.out.println(employee2.getEmployeeId());
        System.out.println(employee2.getStartDate());
    }
}
