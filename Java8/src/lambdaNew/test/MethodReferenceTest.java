package lambdaNew.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import lambdaNew.domain.Apple;
import lambdaNew.domain.Human;
import lambdaNew.functionalInterfaces.Sayable;
import lambdaNew.impl.MethodReference;

class Arithmetic {
	public static int add(int a, int b) {
		return a + b;
	}

	public static float add(int a, float b) {
		return a + b;
	}

	public static float adds(int a, int b) {
		return a + b;
	}

	public static float add(float a, float b) {
		return a + b;
	}
}

public class MethodReferenceTest {

	public static void main(String[] args) {

		// Referring static method
		Sayable sayable = MethodReference::saySomething;
		// Calling interface method
		sayable.say();

		Thread t2 = new Thread(MethodReference::ThreadStatus);
		t2.start();

		// Arithmetic arithmetic = new Arithmetic();
		BiFunction<Integer, Integer, Integer> adder = Arithmetic::add;
		// BiFunction<Integer, Integer, Integer> adder = ( a, b) -> a+b;
		int result = adder.apply(10, 20);
		System.out.println(result);

		BiFunction<Integer, Integer, Integer> adder1 = Arithmetic::add;
		BiFunction<Integer, Float, Float> adder2 = Arithmetic::add;
		BiFunction<Float, Float, Float> adder3 = Arithmetic::add;

		BiFunction<Integer, Integer, Float> adder4 = Arithmetic::adds;

		int result1 = adder1.apply(10, 20);
		float result2 = adder2.apply(10, 20.0f);
		float result3 = adder3.apply(10.0f, 20.0f);
		float result4 = adder4.apply(10, 20);

		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);

		List<Apple> apples = Arrays.asList(
				new Apple("Read Rose", 0,"Afganistan"), 
				new Apple("Dark Red", 21, "Australia"),
				new Apple("Blue", 11, "Sri Lanka"), 
				new Apple("Blue", 4,"Sri Lanka"), 
				new Apple("Blue", 19, "Sri Lanka"),
				new Apple("Purple", 2, "New zeland"), 
				new Apple("Read", 1,"Somalia"));

		apples.sort(Comparator.comparing(Apple::getColor).thenComparing(
				Apple::getWeight));
		
		apples.sort(Comparator.comparing(Apple::getWeight));

		for (Apple apple : apples) {
			System.out.println(apple);
		}
		
		// List based
		  List<Human> humans = Arrays.asList(
			      new Human("Sarah", 10), 
			      new Human("Sarah", 12), 
			      new Human("sanda", 35), 
			      new Human("Max", 12), 
			      new Human("Frank", 25), 
			      new Human("Jack", 33)
			    );
		
		humans.sort(MethodReference::compareByNameThenAge);
		humans.forEach(System.out::println);
		
		System.out.println("\n");
		
		humans.sort((h1, h2) -> h1.getName().compareTo(h2.getName()));
		humans.forEach(System.out::println);
		
		System.out.println("\n");
		
		 Collections.sort(humans, Comparator.comparing(Human::getName));
		 humans.forEach(System.out::println);
		 
		 System.out.println("\n");
		 
		 Comparator<Human> comparator = (h1, h2) -> h1.getName().compareTo(h2.getName());
	     
	    humans.sort(comparator.reversed());
	    humans.forEach(System.out::println);
	    
	    System.out.println("\n");
	    
	    Comparator<Human> comparator2 = MethodReference::compareByNameThenAge;
	    humans.sort(comparator2.reversed());
	    humans.forEach(System.out::println); 
	    
	    System.out.println("\n");
	    
	    humans.sort(Comparator.comparing(Human::getName).thenComparing(Human::getAge));
	    humans.forEach(System.out::println); 
		 
	    System.out.println("\n");
	    //Stream based
	    System.out.println(" ------------ Stream based");    
	  
	    
	    List<String> letters = Arrays.asList("B", "A", "C");
	    letters.stream().sorted();
	    letters.forEach(System.out::println);
	    
	    // reverse
	    letters.stream().sorted(Comparator.reverseOrder());
	    letters.forEach(System.out::println);
	    
	    System.out.println("\n");
	    
	    Comparator<Human> nameComparator = (h1, h2) -> h1.getName().compareTo(h2.getName());
	     
	    List<Human> sortedHumans = 
	    		humans.stream().sorted(nameComparator).collect(Collectors.toList());
	    
	    sortedHumans.forEach(System.out::println); 
	    
	    System.out.println("\n");
	    
//	    List<Human> list1 = humans2.stream().sorted().collect(Collectors.toList());
//	    list1.forEach(System.out::println);
//	    
//	    System.out.println("\n");
	    
	    List<Human> list2 = humans.stream()
	    		.sorted(MethodReference::compareByNameThenAge)
	    		.collect(Collectors.toList());
	    list2.forEach(System.out::println);
	    
	    System.out.println("\n");
	    
	    // using Comparator.comparin
	    List<Human> sortedHumans2 = humans.stream()
	    	      .sorted(Comparator.comparing(Human::getName))
	    	      .collect(Collectors.toList());
	    
	    sortedHumans2.forEach(System.out::println); 
	    
	    // reverse
	    
	    System.out.println("\n");
	    
	    Comparator<Human> reverseNameComparator = 
	    	      (h1, h2) -> h2.getName().compareTo(h1.getName());
	    	 
	    	    humans.stream().sorted(reverseNameComparator)
	    	      .collect(Collectors.toList()).forEach(System.out::println);;
	    
	  
	    // using Comparator.comparin

        System.out.println("\n");
	    	      
		humans.stream()
				.sorted(Comparator.comparing(Human::getName,
						Comparator.reverseOrder()))
				.collect(Collectors.toList()).forEach(System.out::println);
		
		
	}
}
