package ch05.ex06;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Fridays {
	private static final int CENTURY = 20;

	public static List<LocalDate> getFridaysBetween20thCentury() {
        List<LocalDate> days = new ArrayList<>();
        LocalDate day = LocalDate.ofYearDay((CENTURY - 1) * 100 + 1, 13);
        while (day.isBefore(LocalDate.ofYearDay(CENTURY * 100 + 1, 1))) {
            if (day.getDayOfWeek() == DayOfWeek.FRIDAY) {
                days.add(day);
            }
            day = day.plusMonths(1);
        }
        return days;
    }

	public static void main(String[] args) {
		Fridays.getFridaysBetween20thCentury().forEach(System.out::println);
	}
}
