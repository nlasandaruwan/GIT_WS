package lambda.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lambda.custom.Dish;

public class StreamTest {

	public static void main(String[] args) {

		List<Dish> menu = Arrays.asList(
				new Dish("prawns", false, 300, Dish.Type.FISH), 
				new Dish("salmon", false, 450, Dish.Type.FISH),
				new Dish("pork", false, 800, Dish.Type.MEAT), 
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT), 
				new Dish("french fries", true, 530, Dish.Type.OTHER), 
				new Dish("rice", true, 350, Dish.Type.OTHER), 
				new Dish("season fruit", true, 120, Dish.Type.OTHER), 
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER));

		List<Dish> dishs = menu.stream().collect(Collectors.toList());
		List<String> dishs2 = menu.stream()
								.filter(a -> a.getCalories() > 500)
								.sorted((o1, o2) -> o1.getCalories() - o2.getCalories())
								.map(Dish::getName)
								.distinct()
								.skip(1)
								.limit(3)
								.collect(Collectors.toList());

		List<Integer> nameNum = menu.stream()
//								.map(s-> s.getName().length())
								.map(Dish::getName)
								.map(String::length)
								.collect(Collectors.toList());
		
//		System.out.println(menu.stream().anyMatch(Dish::isVegetarian));
		Optional<Dish> optional = menu.stream().filter(a -> a.getCalories() > 1400).findAny();
		
		
//		System.out.println(optional.get().getName());
		
		
		List<Integer> ints = Arrays.asList(1,2,7,34,7,0,8,33,99,2,1,7,0,4,3,66,7,43,56,2,6);
		int dum = ints.stream().reduce(0,(a,b)->a+b);
		int dum2 = ints.stream().reduce(0,Integer::sum);
		System.out.println(dum);
		System.out.println(dum2);
		
		int max = ints.stream().reduce(0,(a,b)->a > b ?a:b);
		int max2 = ints.stream().reduce(0,Integer::max);
		
		System.out.println(max);
		System.out.println(max2);
		
//		System.out.println(nameNum);
//		dishs2.forEach(t-> System.out.println(t.toUpperCase()));
//		dishs2.forEach(t-> System.out.println(t.toUpperCase()));

	}
}
