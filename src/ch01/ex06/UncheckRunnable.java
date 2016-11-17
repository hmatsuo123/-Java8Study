package ch01.ex06;

public class UncheckRunnable {

	@FunctionalInterface
    public interface RunnableEx {
        void run() throws Exception;
    }

	public static Runnable uncheck(RunnableEx runnable) {
        return () -> {
            try {
            	runnable.run();
            } catch (Exception e) {
            	try {
					throw e;
				} catch (Exception e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				}
            }
        };
    }
}
