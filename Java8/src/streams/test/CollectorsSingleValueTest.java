package streams.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import streams.domain.Dish;
import streams.domain.Trader;
import streams.domain.Transaction;

public class CollectorsSingleValueTest {

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
				new Dish("pizza", true, 600, Dish.Type.OTHER), 
				new Dish("pizza", true, 550, Dish.Type.OTHER), 
				new Dish("prawns", false, 300, Dish.Type.FISH), 
				new Dish("salmon", false, 450, Dish.Type.FISH)
				);

		System.out.println(menu.stream().collect(Collectors.counting()));
		System.out.println(menu.stream().count());
		menu.stream().mapToInt(a-> a.getCalories()).max().ifPresent(System.out::println);;

		Optional<Dish> mostCalorieDish = menu.stream().collect(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)));
		System.out.println(mostCalorieDish);
		
		Optional<Dish> minCalorieDish = menu.stream().collect(Collectors.minBy(Comparator.comparingInt(Dish::getCalories)));
		System.out.println(minCalorieDish);
		
		double avg = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
		System.out.println(avg);
		
		int totalCal = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
		System.out.println(totalCal);
		
		IntSummaryStatistics menuStatistics =
				menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
		System.out.println(menuStatistics);
		
		String shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining());
		String shortMenus = menu.stream().map(Dish::getName).reduce((a,b) -> a+b).get();
		String shortMenuss = menu.stream().map(Dish::getName).collect(Collectors.reducing((a,b) -> a+" : "+b)).get();
		System.out.println(shortMenu);
		System.out.println(shortMenus);
		System.out.println("Collectors.reducing :: "+ shortMenuss);
		
//		String shortMenuDish2 = menu.stream().collect(Collectors.joining());
//		Dish shortMenuDish2 = menu.stream().reduce((a,b) -> return a ).get();
		
		String shortMenuComma = menu.stream().map(Dish::getName).collect(Collectors.joining(","));
		System.out.println(shortMenuComma);
		
		int totalCalories = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j));
		System.out.println(totalCalories);
		
		Optional<Dish> mostCalorieDishReducuing = menu.stream().collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
		System.out.println(mostCalorieDishReducuing);
		
		int sumOfnew = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
		System.out.println(sumOfnew);

	}

	public static <T> Collector<T, ?, Long> counting() {
		return Collectors.reducing(0L, e -> 1L, Long::sum);
	}
}
