package ch08.ex03;

public class GcdCalculator {
	public static int gcdByPercent(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while(true) {
        	if (a < b) {
            	a = Math.abs(b);
            	b = Math.abs(a);
            }

        	if (b == 0) {
                return a;
            }

            b = a % b;
            a = b;
        }
    }

    public static int gcdByFloorMod(int a, int b) {
    	a = Math.abs(a);
        b = Math.abs(b);
        while(true) {
        	if (a < b) {
            	a = Math.abs(b);
            	b = Math.abs(a);
            }

        	if (b == 0) {
                return a;
            }

            b = Math.floorMod(a, b);
            a = b;
        }
    }

    public static int gcdByRem(int a, int b) {
    	a = Math.abs(a);
        b = Math.abs(b);
        while(true) {
        	if (a < b) {
            	a = Math.abs(b);
            	b = Math.abs(a);
            }

        	if (b == 0) {
                return a;
            }

            b = Integer.remainderUnsigned(a, b);
            a = b;
        }
    }

    public static void main(String[] args) {
    	System.out.println(gcdByPercent(165, 105));
    	System.out.println(gcdByFloorMod(165, 105));
    	System.out.println(gcdByRem(165, 105));
    }
}
