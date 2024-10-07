package vn.com.iuh.fit.week02.models;

import jakarta.persistence.*;

import java.util.Objects;

@Table(name = "product_image")
public class ProductImage {

    @Id
    @Column(name = "image_id")
    private long image_id;

    @Column(name = "path")
    private String path;

    @Column(name = "alternative")
    private String alternative;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductImage(Product product, String alternative, String path, long image_id) {
        this.product = product;
        this.alternative = alternative;
        this.path = path;
        this.image_id = image_id;
    }

    public ProductImage() {
    }

    public long getImage_id() {
        return image_id;
    }

    public void setImage_id(long image_id) {
        this.image_id = image_id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductImage that = (ProductImage) o;
        return image_id == that.image_id && Objects.equals(path, that.path) && Objects.equals(alternative, that.alternative) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(image_id, path, alternative, product);
    }
}
