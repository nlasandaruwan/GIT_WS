package lambdaNew.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapTest {

	public static void main(String[] args) {

		Optional<String> s = Optional.of("test");
		System.out.println(s.map(String::toUpperCase).get());

		// Optional.of("string").map(s -> Optional.of("STRING"));

		// Optional.of("string").flatMap(s -> Optional.of("STRING"));

		Stream.of("a", "b").map(String::toUpperCase)
				.collect(Collectors.toList()).forEach(System.out::print);
		
		System.out.println();

		List<List<String>> list = Arrays.asList(Arrays.asList("a"), Arrays.asList("b"));
		
		System.out.println(list);
		
		System.out.println(list
				  .stream()
				  .flatMap(Collection::stream)
				  .collect(Collectors.toList()));
		
		System.out.println(list);
		
		List<List<String>> nestedList = Arrays.asList(
				Arrays.asList("one:one"), 
				Arrays.asList("two:one", "two:two", "two:three"), 
				Arrays.asList("three:one", "three:two", "three:three", "three:four"));
		
		flattenListOfListsImperatively(nestedList).forEach(System.out::print);
		
		System.out.println(list);
		
		nestedList.stream().flatMap(Collection::stream).forEach(System.out::print);
		System.out.println(list);
		nestedList.stream().flatMap(flattedList -> flattedList.stream()).forEach(System.out::print);

	}
	
	public static <T> List<T> flattenListOfListsImperatively(List<List<T>> nestedList) {
		List<T> ls = new ArrayList<>();
		nestedList.forEach(ls::addAll);
		return ls;
	}
}
