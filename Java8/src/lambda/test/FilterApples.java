package lambda.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lambda.custom.Apple;
import lambda.functionalInterfaces.Compare;
import lambda.functionalInterfaces.CompareTwo;

public class FilterApples {

	public static void main(String ...args){
		
		String color = "green";
		List<Apple> inventory = Arrays.asList(new Apple(80, "green"),new Apple(155, "green"), new Apple(120, "red"));

//		color = "";
		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
		List<Apple> greenApples = filterApples(inventory, FilterApples::isGreenApple);
		System.out.println(greenApples);
		
		FilterApples filterApples = new FilterApples();
		List<Apple> redApples = filterApples(inventory, filterApples::isRedApple);
		System.out.println(redApples);

		// [Apple{color='green', weight=155}]
		List<Apple> heavyApples = filterApples(inventory, FilterApples::isHeavyApple);
		System.out.println(heavyApples);

		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
		List<Apple> greenApples2 = filterAny(inventory, (a) -> color.equals(a.getColor()));
		System.out.println(greenApples2);

		// [Apple{color='green', weight=155}]
		List<Apple> heavyApples2 = filterAny(inventory, (a) -> a.getWeight() > 150);
		System.out.println(heavyApples2);

		// []
		List<Apple> weirdApples = filterAny(inventory, (a) -> a.getWeight() <= 80 || "brown".equals(a.getColor()));
		System.out.println(weirdApples);
	}

	
	public static List<Apple> filterGreenApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if ("green".equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterHeavyApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (apple.getWeight() > 150) {
				result.add(apple);
			}
		}
		return result;
	}

	public static boolean isGreenApple(Apple apple) {
		return "green".equals(apple.getColor());
	}

	public boolean isRedApple(Apple apple) {
		return "red".equals(apple.getColor());
	}
	
	public static boolean isHeavyApple(Apple apple) {
		return apple.getWeight() > 150;
	}

	
	private static List<Apple> filterApples(List<Apple> inventory, Compare<Apple> p) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.compare(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
	
	private static <T> List<T> filterAny(List<T> inventory, Compare<T> p) {
		List<T> result = new ArrayList<>();
		for (T s : inventory) {
			if (p.compare(s)) {
				result.add(s);
			}
		}
		return result;
	}
	
	/*private static <T,Y> List<T> filterAnyTwo(List<T> inventory, CompareTwo<T, Y> p) {
		List<T> result = new ArrayList<>();
		for (T t : inventory) {
			if (p.compare(t, p)) {
				result.add(t);
			}
		}
		return result;
	}*/
}
