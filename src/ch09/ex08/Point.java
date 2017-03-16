package ch09.ex08;


public class Point {
	private int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int unsafeCompareTo(Point other) {
        int diff = x - other.x;
        if (diff != 0) {
            return diff;
        }
        return y - other.y;
    }

    public int safeCompareTo(Point other) {
        int diff = Integer.compare(x, other.x);
        if (diff != 0) {
            return diff;
        }
        return Integer.compare(y, other.y);
    }
}
