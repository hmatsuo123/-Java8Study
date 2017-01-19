package ch05.ex02;

import java.time.LocalDate;

public class MyLocalDate {

	public static void main(String[] args) {
		LocalDate date1 = LocalDate.of(2000, 2, 29);
		System.out.println("default: " + date1);
		LocalDate date2 = date1.plusYears(1);
		System.out.println("plusYears(1): " + date2);
		LocalDate date3 = date1.plusYears(4);
		System.out.println("plusYears(4): " + date3);
		LocalDate date4 = date1.plusYears(1).plusYears(1).plusYears(1).plusYears(1);
		System.out.println("plusYears(1)*4: " + date4);
	}
}
