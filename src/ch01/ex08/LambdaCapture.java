package ch01.ex08;

import java.util.ArrayList;
import java.util.List;

public class LambdaCapture {

	public void lambdaMethod() {
		String[] names = {"Peter", "Paul", "Mary"};
		List<Runnable> runners = new ArrayList<>();
		for (String name : names)
			runners.add(() -> System.out.println("lambdaMethod: " + name));

		runners.forEach(runner -> new Thread(runner).start());
	}

	public void forLoopMethod() {
        String[] names = {"Peter", "Paul", "Mary"};
        List<Runnable> runners = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            runners.add(() -> System.out.println("forLoopMethod: " + name));
        }

        runners.forEach(runner -> new Thread(runner).start());
    }

	public static void main(String[] args) {
		new LambdaCapture().lambdaMethod();
		new LambdaCapture().forLoopMethod();
	}
}
