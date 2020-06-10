package streams.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import streams.domain.Dish;
import streams.domain.DishComplete;
import streams.domain.Trader;
import streams.domain.Transaction;

public class PartitionTest {

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


		Map<Boolean, List<DishComplete>> partition1 =  menu2.stream().collect(
					Collectors.partitioningBy(DishComplete:: isVegetarian)); 
		
		System.out.println("\n");
		partition1.forEach((k, v) -> System.out.println((k + ":" + v)));	
		
		Map<Boolean, Map<DishComplete.Type,List<DishComplete>>> partition2 =  menu2.stream().collect(
				Collectors.partitioningBy(DishComplete:: isVegetarian, Collectors.groupingBy(DishComplete :: getType))); 
	
		System.out.println("\n");
		partition2.forEach((k, v) -> System.out.println((k + ":" + v)));
		

//		List<DishComplete> partition3 =  menu2.stream().collect(
//					Collectors.partitioningBy(DishComplete:: isVegetarian, 
//							 Collectors.joining()),  Collectors.toList());
		
		/*System.out.println("\n");
		partition3.forEach((k, v) -> System.out.println((k + ":" + v)));*/
		
		System.out.println();
		//Map<Boolean, DishComplete> mostCaloricPartitionedByVegetarian =
				menu2.stream().collect(
						Collectors.partitioningBy(DishComplete::isVegetarian,
						Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparingInt(DishComplete::getCalories)),
				Optional::get))).forEach((k, v) -> System.out.println((k + ":" + v)));
				
				System.out.println();
				
				menu2.stream().collect(Collectors.partitioningBy(DishComplete::isVegetarian,
						Collectors.partitioningBy((DishComplete par) -> par.getCalories() > 500)))
						.forEach((k, v) -> System.out.println((k + ":" + v)));
				
				System.out.println();
				
				menu2.stream().collect(Collectors.partitioningBy(DishComplete::isVegetarian,
						Collectors.counting())).forEach((k, v) -> System.out.println((k + ":" + v)));
				
//				menu2.stream().spliterator().
	}
	
	public enum CaloricLevel { DIET, NORMAL, FAT }
}
