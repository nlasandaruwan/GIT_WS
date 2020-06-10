package streams.test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import streams.domain.Dish;
import streams.domain.Trader;
import streams.domain.Transaction;

public class StreamTypeTest {

	public static void main(String[] args) {
		
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
				);
		
		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800,Dish.Type.MEAT), 
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT), 
				new Dish("french fries", true, 530, Dish.Type.OTHER), 
				new Dish("rice", true, 350, Dish.Type.OTHER), 
				new Dish("season fruit", true, 120, Dish.Type.OTHER), 
				new Dish("pizza", true, 800, Dish.Type.OTHER), 
				new Dish("pizza", true, 550, Dish.Type.OTHER), 
				new Dish("prawns", false, 300, Dish.Type.FISH), 
				new Dish("salmon", false, 450, Dish.Type.FISH)
				);

		
		Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
//		stream.map(String::toUpperCase).forEach(System.out::println);
		
		int[] arr = {2,3,5,7,8,55,9,0};
		String[] arrStr = {"asdas","asda","gdfg","dgeh"};
		
		IntStream stream2 = Arrays.stream(arr);
		Stream<String> stream3 = Arrays.stream(arrStr);
		
		try(Stream<String> lines = Files.lines(Paths.get("A:\\WebServices_Eclipse_WS\\Lambda\\src\\streams\\test\\TransactionsTest.java"), Charset.defaultCharset())){
			
			lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().forEach(System.out::println);;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Stream.iterate(0.0, n -> n + 100000.0).forEach(System.out::println);
		
//		Stream.iterate(new int[]{0, 1},	t -> new int[]{t[1], t[0]+t[1]})
//				.limit(20)
//				.forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));
		
//		Stream.generate(Math::random).limit(5).forEach(System.out::println);
		
		IntSupplier fib = new IntSupplier() {
			private int previous = 0;
			private int current = 1;

			public int getAsInt() {
				int oldPrevious = this.previous;
				int nextValue = this.previous + this.current;
				this.previous = this.current;
				this.current = nextValue;
				return oldPrevious;
			}
		};
//		IntStream.generate(fib).limit(10).forEach(System.out::println);
	}
}
