package AlgoUeb2.util;

public enum Course {
    B1(0),
    B2(1),
    B3(2),
    B4(3),
    B5(4);

    private Course(int value) {
        this.value = value;
    }
    private int value;

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
