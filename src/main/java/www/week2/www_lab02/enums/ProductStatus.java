package www.week2.www_lab02.enums;

public enum ProductStatus {
    ACTIVE(1),      // đang kinh doanh
    ON_LEAVE(0),    // tạm ngung
    TERMINATED(-1); // khong ban nua

    private int value;

    ProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
