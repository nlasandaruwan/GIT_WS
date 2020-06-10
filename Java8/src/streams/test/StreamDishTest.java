package streams.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import streams.domain.Dish;

public class StreamDishTest {
	public static void main(String[] args) {

		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800,Dish.Type.MEAT), 
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT), 
				new Dish("french fries", true, 530, Dish.Type.OTHER), 
				new Dish("rice", true, 350, Dish.Type.OTHER), 
				new Dish("season fruit", true, 120, Dish.Type.OTHER), 
				new Dish("pizza", true, 550, Dish.Type.OTHER), 
				new Dish("pizza", true, 550, Dish.Type.OTHER), 
				new Dish("prawns", false, 300, Dish.Type.FISH), 
				new Dish("salmon", false, 450, Dish.Type.FISH));

//		List<String> list = menu.stream()
//				.filter(t -> { System.out.println("Calling filter(t -> " + t.getCalories() + " - " + t.getName()); return t.getCalories() > 399;})
//				.map(t -> { System.out.println("Calling .map(t -> " + t.getName()); return t.getName();})
//				.limit(4).collect(Collectors.toList());
		
//		System.out.println(list);
		
		/*menu.stream()
				.filter(t -> { 
					//System.out.println("Calling filter(t -> " + t.getCalories() + " - " + t.getName()); 
					return t.getCalories() > 400;})
				.map(t -> { 
					//System.out.println("Calling .map(t -> " + t.getName()); 
					return t.getName();})
				.limit(3).forEach(s -> System.out.println(s));*/
		
		// average calories of all dishes where calorie is greater than 500
//		Double list2 = menu.stream()
//				.filter(t -> { System.out.println("Calling filter(t -> " + t.getCalories()); return t.getCalories() > 500;})
//				.collect(Collectors.averagingInt((Dish t) ->  
//		{ System.out.println("(Dish t) -> " + t.getCalories()); return t.getCalories();}));
		
//		System.out.println(list2);
		
		long count = menu.stream()
				.filter(d -> d.getCalories() > 300)
				.distinct()
				.limit(100)
				.count();
//		System.out.println(count);
		
		
		List<Dish> vegetarianDishes = menu.stream().filter(Dish::isVegetarian).collect(toList());
//		vegetarianDishes.forEach(a -> System.out.println(a.getName()));
		
		List<String> names = Arrays.asList("AA","AA","AAA","AAAAAA","AAAA");
		
//		names.stream().map(a -> a.length()).collect(Collectors.toList()).forEach(System.out::println);
		
		names.stream()
		.map(word -> word.split(""))
		.distinct()
		.collect(toList()).forEach(System.out::println);
		
		
	}
}
