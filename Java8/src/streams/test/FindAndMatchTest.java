package streams.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import streams.domain.Dish;

public class FindAndMatchTest {
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


		if(menu.stream().anyMatch(Dish::isVegetarian)){
			System.out.println("The menu is (somewhat) vegetarian friendly!!");
		}
		
		boolean isHealthy = menu.stream()
				.allMatch(d -> d.getCalories() < 1000);
		System.out.println(isHealthy);
		
		boolean isHealthy2 = menu.stream()
				.noneMatch(d -> d.getCalories() >= 400);
		System.out.println(isHealthy2);
		
		boolean isveg = menu.stream().filter(a -> a.isVegetarian()).anyMatch(Dish::isVegetarian);
		System.out.println(isveg);
	}
}
