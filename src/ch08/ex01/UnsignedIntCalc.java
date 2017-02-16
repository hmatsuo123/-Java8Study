package ch08.ex01;

public class UnsignedIntCalc {
	public static long add(int value, int value2) {
        return Integer.toUnsignedLong(value) + Integer.toUnsignedLong(value2);
    }

    public static long sub(int value, int value2) {
        return Integer.toUnsignedLong(value) - Integer.toUnsignedLong(value2);
    }

    public static int div(int value, int value2) {
        return Integer.divideUnsigned(value, value2);
    }

    public static int compare(int value, int value2) {
        return Integer.compareUnsigned(value, value2);
    }

    public static void main(String[] args) {
    	System.out.println(Integer.MAX_VALUE);
    	System.out.println("add:" + UnsignedIntCalc.add(Integer.MAX_VALUE, 1));
    	System.out.println("sub:" + UnsignedIntCalc.sub(Integer.MAX_VALUE + 2, 1));
    	System.out.println("div:" + UnsignedIntCalc.div(Integer.MAX_VALUE + 1, 2));
    	System.out.println("compare:" + UnsignedIntCalc.compare(Integer.MAX_VALUE, 1));
    }
}
