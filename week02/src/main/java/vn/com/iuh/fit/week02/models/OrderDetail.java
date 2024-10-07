package vn.com.iuh.fit.week02.models;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Objects;

@Table(name = "order_detail")
public class OrderDetail {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "note")
    private String note;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private double quantity;

    public OrderDetail() {
    }

    public OrderDetail(Orders order, Product product, String note, double price, double quantity) {
        this.order = order;
        this.product = product;
        this.note = note;
        this.price = price;
        this.quantity = quantity;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
