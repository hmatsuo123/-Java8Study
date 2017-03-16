package ch08.ex02;


public class NegateExact {
	public static void main(String[] args) {
    	try {
    		 Math.negateExact(Integer.MIN_VALUE);
    	}
    	catch (Exception e) {
    		System.out.println("OK");
    	}
    }
}
