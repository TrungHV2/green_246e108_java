package com.greenacademy.entity;

import java.sql.Timestamp;

public class EmployeeEntity {
    private String employeeId;
    private String employeeName;
    private Timestamp startDate;
    private String phone;

    public EmployeeEntity() {
    }

    public EmployeeEntity(String employeeId, String employeeName, Timestamp startDate, String phone) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.startDate = startDate;
        this.phone = phone;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
