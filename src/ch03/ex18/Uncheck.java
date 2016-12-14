package ch03.ex18;

import java.util.function.Function;

public class Uncheck {

	public static <T, U> Function<T, U> unchecked(FunctionCallable<T, U> f) {
        return (u) -> {
            try {
                return f.call(u);
            } catch (Exception e) {
                throw new RuntimeException(e);
            } catch (Throwable t) {
                throw t;
            }
        };
    }

	public static void main(String[] args) {
		try {
			System.out.println(unchecked((u) -> {
				if (u.equals("OK"))
					return "OK";
				else
					throw new RuntimeException("RuntimeException");
			}).apply("OK"));

			System.out.println(unchecked((u) -> {
				if (u.equals("OK"))
					return "OK";
				else
					throw new RuntimeException("RuntimeException");
			}).apply("NG"));
		}
		catch (RuntimeException e) {
			System.out.println("NG: " + e.getMessage());
		}
	}
}
