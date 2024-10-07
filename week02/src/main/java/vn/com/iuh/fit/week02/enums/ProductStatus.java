package vn.com.iuh.fit.week02.enums;

public enum ProductStatus {
    Active (1),
    Inactive (0),
    Discontinued (-1);

    private final int value;

    private ProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
