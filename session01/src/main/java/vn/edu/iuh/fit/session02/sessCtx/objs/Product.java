package vn.edu.iuh.fit.session02.sessCtx.objs;

public class Product {
    private long productId;
    private String productName;
    private String description;
    private double price;

    public Product() {
    }

    public Product(long productId, String productName, String description, double price) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;
        return productId == product.productId;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(productId);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
