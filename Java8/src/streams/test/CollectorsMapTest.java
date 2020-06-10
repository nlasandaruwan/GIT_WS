package streams.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import streams.domain.Dish;
import streams.domain.DishComplete;
import streams.domain.Trader;
import streams.domain.Transaction;

public class CollectorsMapTest {

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

		List<DishComplete> menu2 = Arrays.asList(
				
				new DishComplete("pork", false, 800,DishComplete.Type.MEAT, 1000), 
				new DishComplete("beef", false, 700, DishComplete.Type.MEAT, 1200),
				new DishComplete("chicken", false, 400, DishComplete.Type.MEAT, 800), 
				new DishComplete("Turkey", false, 500, DishComplete.Type.MEAT, 800), 
				new DishComplete("Turkey Ham", false, 450, DishComplete.Type.MEAT, 800), 
				
				new DishComplete("french fries", true, 530, DishComplete.Type.OTHER, 200), 
				new DishComplete("rice", true, 350, DishComplete.Type.OTHER, 100), 
				new DishComplete("season fruit", true, 120, DishComplete.Type.OTHER, 250), 
				new DishComplete("pizza", true, 550, DishComplete.Type.OTHER, 450), 
				new DishComplete("pizza Cheese", true, 750, DishComplete.Type.OTHER, 550), 
				
				new DishComplete("prawns", false, 300, DishComplete.Type.FISH, 1100), 
				new DishComplete("salmon", false, 450, DishComplete.Type.FISH,1500),
				new DishComplete("Mushroom", false, 200, DishComplete.Type.ORGANIC,250)
				
				);

		Map<Dish.Type, List<Dish>> dishesByType =
				menu.stream().collect(Collectors.groupingBy(Dish::getType));
		
//		System.out.println("\n");
		dishesByType.forEach((k, v) -> System.out.println((k + ":" + v)));
		
		Map<CaloricLevel, List<Dish>> dishesByCaloricLevel2 = menu.stream().collect(
				Collectors.groupingBy((Dish dish) -> {
				if (dish.getCalories() <= 400) return CaloricLevel.DIET;
				else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
				else return CaloricLevel.FAT;
				} ));
		
		
		System.out.println("\n");
		dishesByCaloricLevel2.forEach((k, v) -> System.out.println((k + ":" + v)));
		
		Map<String, List<Dish>> dishesByCaloricLevel3 = menu.stream().collect(Collectors.groupingBy(dish -> { 
					if(dish.getCalories() <=300) return "LOW";
					else if(dish.getCalories() <=700) return "NORMAL";
					else return "FAT";
				}));
		
		System.out.println("\n");
		dishesByCaloricLevel3.forEach((k, v) -> System.out.println((k + ":" + v)));
		
		
		
		Map< DishComplete.Type ,Map<String, List<DishComplete>>> dishesByCaloricLevelTwoLevel = menu2.stream()
				.collect(Collectors.groupingBy(DishComplete::getType,
						 Collectors.groupingBy((DishComplete dish) -> { 
							 if(dish.getCalories() <=300) return "LOW";
							 else if(dish.getCalories() <=700) return "NORMAL";
							 else return "FAT";
						 }
						 )));
		
		System.out.println("\n");
		dishesByCaloricLevelTwoLevel.forEach((k, v) -> System.out.println((k + ":" + v)));
		
		System.out.println("\n");
		
		Map<DishComplete.Type ,Map<String, Map<Integer, List<DishComplete>>>> dishesByCaloricLevelThreeLevel = 
				menu2.stream()
				.collect(Collectors.groupingBy(DishComplete::getType,
						 Collectors.groupingBy((DishComplete dish) -> { 
							 if(dish.getCalories() <=300) return "LOW";
							 else if(dish.getCalories() <=700) return "NORMAL";
							 else return "FAT";
						 }
						 ,Collectors.groupingBy((DishComplete dish) -> dish.getPrice()) )));
		
		
		dishesByCaloricLevelThreeLevel.forEach((k, v) -> System.out.println((k + ":" + v)));
		
		System.out.println("\n");
		
		Map<DishComplete.Type ,Map<String, Long>> dishesByCaloricLevelThreeLevel2 = 
		menu2.stream()
		.collect(Collectors.groupingBy(DishComplete::getType,
				 Collectors.groupingBy((DishComplete dish) -> { 
					 if(dish.getCalories() <=300) return "LOW";
					 else if(dish.getCalories() <=700) return "NORMAL";
					 else return "FAT";
				 },Collectors.counting())));
		
		
		dishesByCaloricLevelThreeLevel2.forEach((k, v) -> System.out.println((k + ":" + v)));
		
		System.out.println("\n");
		
		Map<DishComplete.Type, Long> typesCount = menu2.stream().collect(
				Collectors.groupingBy(DishComplete::getType, counting()));
		
		typesCount.forEach((k, v) -> System.out.println((k + ":" + v)));
		
		Map<DishComplete.Type, Optional<DishComplete>> typeMax = 
		menu2.stream().collect(
				Collectors.groupingBy(DishComplete::getType, 
						Collectors.maxBy((DishComplete a, DishComplete b)-> a.getCalories() > b.getCalories() ? a.getCalories() : b.getCalories())));
		
		System.out.println("\n");
		typeMax.forEach((k, v) -> System.out.println((k + ":" + v)));
	}
	
	
	
	public static <T> Collector<T, ?, Long> counting() {
		return Collectors.reducing(0L, e -> 1L, Long::sum);
	}
	
	public enum CaloricLevel { DIET, NORMAL, FAT }
}
