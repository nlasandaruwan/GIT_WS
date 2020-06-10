package streams.test;

import java.util.function.Function;
import java.util.stream.LongStream;

public class Parallel {

	public static void main(String[] args) {

		/*
		 * System.out.println("Sequential sum done in: " + measureSumPerf((b) ->
		 * b * b, 10_000_000) + " msecs");
		 */

		System.out.println(sideEffectSum(1_000_000_000));
		System.out.println(sideEffectParallelSum(1_000_000_000));
		
		System.out.println("SideEffect parallel sum done in: " +
				measureSumPerf(Parallel::sideEffectParallelSum, 1_000_000_000L) + "msecs" );
		System.out.println("SideEffect sum done in: " +
				measureSumPerf(Parallel::sideEffectSum, 1_000_000_000L) + "msecs" );

	}

	public static long sideEffectParallelSum(long n) {
		Accumulator accumulator = new Accumulator();
		LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
		return accumulator.total;
	}

	public static long sideEffectSum(long n) {
		Accumulator accumulator = new Accumulator();
		LongStream.rangeClosed(1, n).forEach(accumulator::add);
		return accumulator.total;
	}

	public static long measureSumPerf(Function<Long, Long> adder, long n) {
		long fastest = Long.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			long start = System.nanoTime();
			long sum = adder.apply(n);
			long duration = (System.nanoTime() - start) / 1_000_000;
			System.out.println("Result: " + sum);
			if (duration < fastest)
				fastest = duration;
		}
		return fastest;
	}

	public enum CaloricLevel {
		DIET, NORMAL, FAT
	}
}

class Accumulator {
	public long total = 0;

	public void add(long value) {
		total += value;
	}
}