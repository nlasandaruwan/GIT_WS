package streams.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import streams.domain.Dish;
import streams.domain.Trader;
import streams.domain.Transaction;

public class TransactionsTest {

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

		
//		transactions.stream().filter(a -> {  if(a.getYear() == 2011){System.out.println(a);} return a.getYear() == 2011;}).sorted(Comparator.comparingInt(Transaction::getYear)).forEach(System.out::println);
//		transactions.stream().filter(a -> a.getYear() == 2011).map(a -> a.getValue()).sorted().forEach(System.out::println);
		
//		transactions.stream().map(a -> a.getTrader().getCity()).distinct().sorted().forEach(System.out::println);
		
//		transactions.stream()
//		.filter(a -> { return a.getTrader().getCity().equals("Cambridge");})
//		.map(a -> a.getTrader())
//		.distinct()
//		.sorted(Comparator.comparing(Trader::getName))
//		.forEach(System.out::println);

//		String s = transactions.stream()
//		.map(a -> a.getTrader().getName())
//		.sorted()
//		.reduce("", (a,b)-> a +" "+b).toString();	
//		System.out.println(s);
		
//		System.out.println(transactions.stream().anyMatch(a -> a.getTrader().getCity().equals("Milan")));
		
//		transactions.stream()
//		.filter(a -> a.getTrader().getCity().equals("Cambridge"))
//		.map(a -> a.getValue())
//		.forEach(System.out::println);
		
//		System.out.println(transactions.stream().map(a -> a.getValue()).reduce(Integer::max));
//		System.out.println(transactions.stream().map(a -> a.getValue()).reduce(Integer::min));
		
//		Optional<Integer> opt = transactions.stream().map(Transaction::getValue).max((a,b) -> a>b ?b : a);
//		System.out.println(opt);
//		
//		OptionalInt optInt = transactions.stream().mapToInt(Transaction::getValue).max();
//		
//		System.out.println(optInt);
//		
//		int allOld  = transactions.stream().map(Transaction::getValue).reduce(0, Integer::sum);;
//		System.out.println(allOld);
//		
//		int all = transactions.stream().mapToInt(Transaction::getValue).sum();
//		System.out.println(all);
//		
//		IntStream intStream = transactions.stream().mapToInt(Transaction::getValue);
//		Stream<Integer> stream = intStream.boxed();
		
/*		OptionalInt maxCalories = menu.stream()
//				.filter(a -> a.getCalories()>1000)
				.mapToInt(Dish::getCalories)
				.max();
		maxCalories.orElse(100);
		
		System.out.println(maxCalories);*/
		
		// inclusive the 100
//		IntStream intStream = IntStream.rangeClosed(1, 100).filter((a -> a%2==0));
//		System.out.println(intStream.count());
		
		// Exclusive the 100
//		IntStream intStream2 = IntStream.range(1, 100).filter((a -> a%2==0));
//		System.out.println(intStream2.count());
		
	}
}
