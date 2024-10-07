package vn.com.iuh.fit.week02.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Table(name = "orders")
public class Orders {

    @Id
    @Column(name = "order_id")
    private long order_id;

    @Column(name = "order_date")
    private LocalDateTime order_date;

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

    public Orders() {
    }

    public Orders(long order_id, LocalDateTime order_date, Customer customer, Employee employee) {
        this.order_id = order_id;
        this.order_date = order_date;
        this.customer = customer;
        this.employee = employee;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public LocalDateTime getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDateTime order_date) {
        this.order_date = order_date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return order_id == orders.order_id && Objects.equals(order_date, orders.order_date) && Objects.equals(customer, orders.customer) && Objects.equals(employee, orders.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_id, order_date, customer, employee);
    }
}
