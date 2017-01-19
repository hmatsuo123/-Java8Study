package ch05.ex04;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Cal {
	private final LocalDate targetDate;

	public Cal(int month, int year) {
		targetDate = LocalDate.of(year, month, 1);
	}

	public void printCalendar() {
		System.out.printf("%7d月 %d%n", targetDate.getMonthValue(), targetDate.getYear());
		System.out.println("月 火 水 木 金 土 日");

		DayOfWeek dayOfWeek = DayOfWeek.MONDAY;
		while (dayOfWeek.getValue() < targetDate.getDayOfWeek().getValue()) {
			System.out.printf("   ");
			dayOfWeek = dayOfWeek.plus(1);
		}

		LocalDate day = targetDate;
		while (targetDate.getMonth() == day.getMonth()) {
			String text = dayOfWeek == DayOfWeek.SUNDAY ?
					String.format("%2d" + System.getProperty("line.separator"), day.getDayOfMonth()) :
						String.format("%2d ", day.getDayOfMonth());
					System.out.printf(text);

					dayOfWeek = dayOfWeek.plus(1);
					day = day.plusDays(1);
		}

	}

	public static void main(String[] args) {
		args = new String[]{ "3", "2013" };
		if (args.length < 2)
			System.out.println("パラメーターエラー。月と年を入力してください(例：3 2013)");
		else
			new Cal(Integer.parseInt(args[0]), Integer.parseInt(args[1])).printCalendar();
	}
}
