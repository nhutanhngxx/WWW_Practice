package vn.com.iuh.fit.week02.enums;

public enum EmployeeStatus {
    Working (1),
    Temporarily_leave (0),
    Quit (-1);

    private final int value;

    private EmployeeStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
