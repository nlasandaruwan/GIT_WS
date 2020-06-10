package streams.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import streams.domain.Dish;

public class ReduceTest {
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


		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, -5,30);
		int sum = numbers.stream().reduce(1, Integer::sum);
		System.out.println(sum);
		
		Optional<Integer> sums = numbers.stream().reduce((a, b) -> (a + b));
		sums.ifPresent(System.out::println);
		
		Optional<Integer> max = numbers.stream().reduce(Integer::max);
		Optional<Integer> max2 = numbers.stream().reduce((a,b)-> a>b ? a:b);
		
		System.out.println(max);
		System.out.println(max2);
		
		Optional<Integer> min = numbers.stream().reduce(Integer::min);
		Optional<Integer> min2 = numbers.stream().reduce((a,b)-> a<b ? a:b);
		
		System.out.println(min);
		System.out.println(min2);
		
		int dishes = menu.stream().map(a-> 1).reduce(0, (a,b) -> a+b);
		long dishesCount = menu.stream().count();
		
		System.out.println(dishes);
		System.out.println(dishesCount);
		
		"Hello world!".chars()
		.forEach(System.out::print);
	}
}
