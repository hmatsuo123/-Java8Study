package ch05.ex05;

import java.time.Duration;
import java.time.LocalDateTime;

public class LifeElapsedTime {
	private LocalDateTime birthDay;

    public LifeElapsedTime(int year, int month, int day) {
    	birthDay = LocalDateTime.of(year, month, day, 0, 0);
    }

	public long get() {
        return Duration.between(birthDay, LocalDateTime.now()).toDays();
    }

	public static void main(String[] args) {
		System.out.println(new LifeElapsedTime(2017, 1, 10).get());
		System.out.println(new LifeElapsedTime(1988, 9, 1).get());
	}
}
