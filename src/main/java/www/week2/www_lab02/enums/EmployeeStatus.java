package www.week2.www_lab02.enums;

public enum EmployeeStatus {
    ACTIVE(1),      // đang làm việc
    ON_LEAVE(0),    // tạm nghỉ
    TERMINATED(-1); // nghỉ việc

    private int value;

    EmployeeStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
