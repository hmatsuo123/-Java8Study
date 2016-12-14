package ch03.ex01;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerEx extends Logger {

	protected LoggerEx(String name, String resourceBundleName) {
		super(name, resourceBundleName);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public boolean logIf(Level level, BooleanSupplier condition, Supplier<String> msgSupplier) {
		if (isLoggable(level) && condition.getAsBoolean()) {
			log(level, msgSupplier);
			return true;
		}
		return false;
	}

	// TODO: キャストに失敗する
	public static LoggerEx getLogger(String name) {
		return (LoggerEx)Logger.getLogger(name);
    }

	public static void main(String[] args) {
		LoggerEx logger = LoggerEx.getLogger("LoggerEx");
		logger.warning(() -> "test");
	}
}
