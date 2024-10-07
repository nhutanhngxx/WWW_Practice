package vn.com.iuh.fit.week02.models;

import vn.com.iuh.fit.week02.enums.EmployeeStatus;

import java.time.LocalDateTime;
import java.util.Objects;

public class Employee {
    private long emp_id;
    private String full_name;
    private LocalDateTime dod;
    private String email;
    private String phone;
    private String address;
    private EmployeeStatus status;

    public long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(long emp_id) {
        this.emp_id = emp_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public LocalDateTime getDod() {
        return dod;
    }

    public void setDod(LocalDateTime dod) {
        this.dod = dod;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public Employee(long emp_id, String full_name, LocalDateTime dod, String email, String phone, String address, EmployeeStatus status) {
        this.emp_id = emp_id;
        this.full_name = full_name;
        this.dod = dod;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    public Employee() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return emp_id == employee.emp_id && Objects.equals(full_name, employee.full_name) && Objects.equals(dod, employee.dod) && Objects.equals(email, employee.email) && Objects.equals(phone, employee.phone) && Objects.equals(address, employee.address) && status == employee.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(emp_id, full_name, dod, email, phone, address, status);
    }
}