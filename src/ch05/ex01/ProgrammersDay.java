package ch05.ex01;

import java.time.LocalDate;

public class ProgrammersDay {
	public static LocalDate get(int year) {
        return LocalDate.of(year, 1, 1).plusDays(255);
    }

	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2017, 1, 1);
		System.out.println(ProgrammersDay.get(2017) + ", isLeapYear=" + date.isLeapYear());
		date = LocalDate.of(2000, 1, 1);
		System.out.println(ProgrammersDay.get(2000) + ", isLeapYear=" + date.isLeapYear());
	}
}
