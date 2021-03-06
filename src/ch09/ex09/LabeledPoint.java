package ch09.ex09;

import java.util.Objects;

public class LabeledPoint {
	private String label;
    private int x, y;

    public LabeledPoint(int x, int y, String label) {
        this.x = x;
        this.y = y;
        this.label = label;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null) {
            return false;
        }
        if (getClass() != otherObject.getClass()) {
            return false;
        }
        LabeledPoint other = (LabeledPoint) otherObject;
        return Objects.equals(x, other.x) && Objects.equals(y, other.y) && Objects.equals(label, other.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, label);
    }
}
