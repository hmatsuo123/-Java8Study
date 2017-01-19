package ch05.ex03;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Predicate;

public class TemporalAdjusterFactory {
    public static TemporalAdjuster next(Predicate<LocalDate> predicate) {
        return TemporalAdjusters.ofDateAdjuster(w -> {
            LocalDate result = w;
            do {
                result = result.plusDays(1);
            } while (predicate.negate().test(result));
            return result;
        });
    }

    public static void main(String[] args) {
        //LocalDate today = LocalDate.now();
    	LocalDate date = LocalDate.of(2017, 1, 21);
        System.out.println(date);
        LocalDate next = date.with(next(w -> w.getDayOfWeek().getValue() < 6));
        System.out.println(next);
    }
}
