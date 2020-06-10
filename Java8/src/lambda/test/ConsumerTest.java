package lambda.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import lambda.custom.Apple;
import lambda.custom.Car;
import lambda.functionalInterfaces.Constructor;
import lambda.functionalInterfaces.FunctionMultiParam;
import lambda.functionalInterfaces.VoidConsumer;

public class ConsumerTest {

	public static void main(String[] args) {
		
		List<Apple> inventory = Arrays.asList(new Apple(80, "green"),new Apple(155, "green"), new Apple(120, "red"));
		List<Car> inventoryCars = Arrays.asList(new Car("Astral",509999),new Car("Lambogini",76876567), new Car("Ferrari",54545454));
		
//		consumeAny(inventory, (Apple a)->{System.out.println(a.getColor());
//											System.out.println(a.getWeight()+"\n");});
//		
		consumeAny(inventoryCars, (Car a)->{System.out.println(a.getBrand());});
		
		List<String> str = Arrays.asList("a","b","A","B");
//		str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
		
		str.sort(String::compareToIgnoreCase);
		
//		System.out.println(str);
		
		Constructor<Apple> c1 = Apple::new;
		Constructor<Apple> c2 = ()-> new Apple(123,"Wer");
		
		VoidConsumer<Apple> consumer = (Apple s)-> new Apple(123,"Wer");
		
//		System.out.println(consumer);
//		System.out.println(c2.get());
		
		Function<Integer, Apple> function = Apple::new;
		
		FunctionMultiParam<Integer, String, Apple> functionMulti = Apple::new;
		
		System.out.println(functionMulti.apply(22,"REDDD"));
		
 	}
	
	public static <T> void consumeAny(List<T> list, VoidConsumer<T> to){
		
		for (T t : list) {
			to.consume(t);
//			System.out.println(t);
		}
	}
	
	
}
