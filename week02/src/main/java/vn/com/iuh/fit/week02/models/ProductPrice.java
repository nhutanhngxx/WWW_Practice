package vn.com.iuh.fit.week02.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

public class ProductPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_date_time")
    private LocalDateTime price_date_time;

    @Column(name = "note")
    private String note;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public ProductPrice() {
    }

    public ProductPrice(LocalDateTime price_date_time, String note, double price, Product product) {
        this.price_date_time = price_date_time;
        this.note = note;
        this.price = price;
        this.product = product;
    }

    public LocalDateTime getPrice_date_time() {
        return price_date_time;
    }

    public void setPrice_date_time(LocalDateTime price_date_time) {
        this.price_date_time = price_date_time;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
