package ch02.ex10;

import java.util.DoubleSummaryStatistics;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AverageCalculator {

	public double caluculateAverage(Stream<Double> stream) {
		DoubleSummaryStatistics summary = stream.collect(Collectors.summarizingDouble(d -> { return d;}));
		double sum = summary.getSum();
		long count = summary.getCount() - 1;
		System.out.printf("%f / %d = %f", sum, count, sum / count);
		return sum / count;
	}

	// TODO: 実行するとエラーになる
	public double caluculateAverage2(Stream<Double> stream) {
		AtomicInteger count = new AtomicInteger();
		double sum = stream.reduce(0.0, (a, b) -> {
			count.getAndIncrement();
			return a + b;
		});
		System.out.printf("%f / %d = %f", sum, count.get(), sum / count.get());
		return sum / count.get();
	}

	public static void main(String[] args) {
		Stream<Double> stream = IntStream.rangeClosed(0, 10).asDoubleStream().boxed();
		double result = new AverageCalculator().caluculateAverage2(stream);
	}
}
