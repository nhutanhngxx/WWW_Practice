package vn.com.iuh.fit.week02.models;

import jakarta.persistence.*;
import vn.com.iuh.fit.week02.enums.ProductStatus;

import java.util.Objects;

@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long product_id;

    @OneToMany
    private OrderDetail orderDetail;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "unit")
    private String unit;

    @Column(name = "manufacturer_name")
    private String manufacturer_name;

    @Column(name = "status")
    private ProductStatus status;

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getManufacturer_name() {
        return manufacturer_name;
    }

    public void setManufacturer_name(String manufacturer_name) {
        this.manufacturer_name = manufacturer_name;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public Product(long product_id, String name, String description, String unit, String manufacturer_name, ProductStatus status) {
        this.product_id = product_id;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturer_name = manufacturer_name;
        this.status = status;
    }

    public Product() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return product_id == product.product_id && unit == product.unit && manufacturer_name == product.manufacturer_name && Objects.equals(name, product.name) && Objects.equals(description, product.description) && status == product.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_id, name, description, unit, manufacturer_name, status);
    }
}
