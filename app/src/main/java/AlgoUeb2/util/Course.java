package AlgoUeb2.util;

import java.security.InvalidParameterException;

public enum Course {
    B1(0),
    B2(1),
    B3(2),
    B4(3),
    B5(4);

    private int value;

    private Course(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static Course getValue(int courseNumber) {
        if(courseNumber >= Course.values().length) {
        }
        for (int i = 0; i < Course.values().length; i++) {
            Course c = Course.values()[i];
            if(c.getValue() == courseNumber) {
                return c;
            }
        }
        throw new InvalidParameterException("Parameter out of bounds.");
    }
}
